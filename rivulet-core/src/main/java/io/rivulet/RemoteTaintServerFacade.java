package io.rivulet;

import io.rivulet.internal.EmbeddedMessage;
import io.rivulet.internal.rerun.TestRerunConfiguration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RemoteTaintServerFacade implements Closeable {
	private final DataOutputStream dataOutputStream;
	private final DataInputStream dataInputStream;
	private final Socket socket;

	public RemoteTaintServerFacade(int remoteServerPort) throws IOException {
		this.socket = new Socket("localhost", remoteServerPort);
		this.socket.setTcpNoDelay(true);
		this.dataOutputStream = new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
		this.dataInputStream = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}

	public void testSetStarting(String className) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_SET_STARTED.ordinal());
			this.dataOutputStream.writeInt(1);
			this.dataOutputStream.writeUTF(className);
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void testStarting(String className, String methodName) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_STARTED.ordinal());
			this.dataOutputStream.writeInt(2);
			this.dataOutputStream.writeUTF(className);
			if(methodName != null)
				this.dataOutputStream.writeUTF(methodName);
			else
				this.dataOutputStream.writeUTF("null");
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void testSetCompleted(String className) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_SET_ENDED.ordinal());
			if (className != null) {
				this.dataOutputStream.writeInt(1);
				this.dataOutputStream.writeUTF(className);
			} else {
				this.dataOutputStream.writeInt(0);
			}
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public int testSucceeded(String sourceName, String methodName) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_SUCCEEDED.ordinal());
			this.dataOutputStream.writeInt(2);
			this.dataOutputStream.writeUTF(sourceName);
			if(methodName != null)
				this.dataOutputStream.writeUTF(methodName);
			else
				this.dataOutputStream.writeUTF("null");
			this.dataOutputStream.flush();
			return this.dataInputStream.readInt();
		} catch (IOException e) {
			throw new IllegalStateException("Unable to c" +
					"onnect to remote server", e);
		}
	}

	public int testError(String sourceName, String methodName) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_ERRORED.ordinal());
			this.dataOutputStream.writeInt(2);
			this.dataOutputStream.writeUTF(sourceName);
			if(methodName != null)
				this.dataOutputStream.writeUTF(methodName);
			else
				this.dataOutputStream.writeUTF("null");
			this.dataOutputStream.flush();
			return this.dataInputStream.readInt();
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public int testFailed(String sourceName, String methodName) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.TEST_FAILED.ordinal());
			this.dataOutputStream.writeInt(2);
			this.dataOutputStream.writeUTF(sourceName);
			if(methodName != null)
				this.dataOutputStream.writeUTF(methodName);
			else
				this.dataOutputStream.writeUTF("null");
			this.dataOutputStream.flush();
			return this.dataInputStream.readInt();
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void initListener(String rerunConfigsPath, String violationReportsPath, String criticalReproductionPath) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.INIT_LISTENER.ordinal());
			if (criticalReproductionPath == null)
				this.dataOutputStream.writeInt(2);
			else
				this.dataOutputStream.writeInt(3);
			this.dataOutputStream.writeUTF(rerunConfigsPath);
			this.dataOutputStream.writeUTF(violationReportsPath);
			if (criticalReproductionPath != null)
				this.dataOutputStream.writeUTF(criticalReproductionPath);
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public int getNumberOfViolations() {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.VIOLATIONS_INQUIRY.ordinal());
			this.dataOutputStream.writeInt(0);
			this.dataOutputStream.flush();
			return this.dataInputStream.readInt();
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void addWebApp(String name, String warFilePath) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.DEPLOY_WEBAPP.ordinal());
			this.dataOutputStream.writeInt(2);
			this.dataOutputStream.writeUTF(name);
			this.dataOutputStream.writeUTF(warFilePath);
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void setCurrentRerunConfigAndAutotainters(TestRerunConfiguration config) {
		try{
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.SET_RERUN_CONFIG.ordinal());
			this.dataOutputStream.writeInt(-1);
			ObjectOutputStream oos = new ObjectOutputStream(this.dataOutputStream);
			oos.writeObject(config);
			oos.flush();
			this.dataInputStream.readByte();
		} catch(IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public void setReruns(boolean b) {
		try {
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.SET_RERUNS_MODE.ordinal());
			this.dataOutputStream.writeInt(1);
			this.dataOutputStream.writeUTF(Boolean.toString(b));
			this.dataOutputStream.flush();
			this.dataInputStream.readByte(); //Wait for "OK" to avoid a race
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public TestRerunConfiguration getCurrentRerunConfig(){
		try{
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.GET_RERUN_CONFIG.ordinal());
			this.dataOutputStream.writeInt(0);
			this.dataOutputStream.flush();
			ObjectInputStream ois = new ObjectInputStream(dataInputStream);
			TestRerunConfiguration ret = (TestRerunConfiguration) ois.readObject();
			return ret;
		} catch (IOException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}

	public boolean checkAndClearReachedSink(){
		try{
			this.dataOutputStream.writeByte(EmbeddedMessage.MessageType.CHECK_AND_CLEAR_REACHED_SINK.ordinal());
			this.dataOutputStream.writeInt(0);
			this.dataOutputStream.flush();
			boolean ret = this.dataInputStream.readBoolean();
			return ret;
		}catch(IOException e){
			throw new IllegalStateException("Unable to connect to remote server", e);
		}
	}
}
