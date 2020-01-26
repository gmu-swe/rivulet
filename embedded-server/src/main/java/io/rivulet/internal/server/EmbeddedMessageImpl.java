package io.rivulet.internal.server;

import io.rivulet.fuzz.RivuletJUnitCoreProvider;
import io.rivulet.internal.EmbeddedMessage;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.rerun.TestRerunConfiguration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmbeddedMessageImpl extends EmbeddedMessage {


	public static EmbeddedMessageImpl fromInput(DataInputStream is) throws IOException, ClassNotFoundException {
		EmbeddedMessageImpl ret = new EmbeddedMessageImpl();
		ret.type = MessageType.values()[is.readByte()];
		int len = is.readInt();
		if (len == -1) {
			ObjectInputStream ois = new ObjectInputStream(is);
			ret.arg = ois.readObject();
		} else {
			ret.args = new String[len];
			for (int i = 0; i < ret.args.length; i++) {
				ret.args[i] = is.readUTF();
			}
		}
		return ret;
	}


	public void apply(EmbeddedServer embeddedServer, DataOutputStream outputStream) throws IOException {
//		System.out.println("Applying: " + type + " " + Arrays.toString(args) + " " + arg);
		switch (type) {
			case DEPLOY_WEBAPP:
				embeddedServer.addWebApp(args[1], args[0]);
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case VIOLATIONS_INQUIRY:
				outputStream.writeInt(RivuletAutoTaintWrapper.getViolations().size());
				outputStream.flush();
				break;
			case SET_RERUNS_MODE:
				boolean v = Boolean.valueOf(args[0]);
				RivuletJUnitCoreProvider.isReruns = v;
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case SET_RERUN_CONFIG:
				embeddedServer.setRerunConfigAndResetAutoTaint((TestRerunConfiguration) arg);
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case INIT_LISTENER:
				embeddedServer.initListener(args[0], args[1], (args.length > 2 ? args[2] : null));
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case TEST_SET_STARTED:
				embeddedServer.getTaintTrackingTestListener().testSetStarted(args[0]);
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case TEST_SET_ENDED:
				embeddedServer.getTaintTrackingTestListener().testSetEnded((args.length == 0 ? null : args[0]));
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case TEST_STARTED:
				embeddedServer.getTaintTrackingTestListener().testStarted(args[0], args[1]);
				outputStream.writeByte(MessageType.OK.ordinal());
				outputStream.flush();
				break;
			case TEST_ERRORED:
				int numViolations = embeddedServer.getTaintTrackingTestListener().testError(args[0], args[1]);
				outputStream.writeInt(numViolations);
				outputStream.flush();
				break;
			case TEST_FAILED:
				numViolations = embeddedServer.getTaintTrackingTestListener().testFailed(args[0], args[1]);
				outputStream.writeInt(numViolations);
				outputStream.flush();
				break;
			case TEST_SUCCEEDED:
				numViolations = embeddedServer.getTaintTrackingTestListener().testSucceeded(args[0], args[1]);
				outputStream.writeInt(numViolations);
				outputStream.flush();
				break;
			case OK:
				break;
			case CHECK_AND_CLEAR_REACHED_SINK:
				outputStream.writeBoolean(RivuletAutoTaintWrapper.checkAndClearReachedSink());
				outputStream.flush();
				break;
			case GET_RERUN_CONFIG:
				ObjectOutputStream oos = new ObjectOutputStream(outputStream);
				oos.writeObject(RivuletAutoTaintWrapper.getCurrentRerunConfig());
				oos.flush();
				break;
			case ERROR:
			default:
				throw new UnsupportedOperationException();

		}
	}


}
