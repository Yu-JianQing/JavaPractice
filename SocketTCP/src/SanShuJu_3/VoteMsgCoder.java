package SanShuJu_3;

import java.io.IOException;

public interface VoteMsgCoder {
	byte[] toWire(VoteMsg msg) throws IOException;
	VoteMsg fromWire(byte[] msg)throws IOException;
}
