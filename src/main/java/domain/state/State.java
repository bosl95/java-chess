package domain.state;

import domain.pieces.Piece;
import domain.pieces.Pieces;

import java.util.Set;

public interface State {
	State pushCommend(String input);

	boolean isReported();

	boolean isPlaying();

	Set<Piece> getSet();

	Pieces getPieces();
}