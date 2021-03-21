package domain.piece;

import domain.Board;
import domain.PieceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

    @DisplayName("King은 상하좌우 모든 대각선 방향으로 1칸 이동할 수 있다.(목적지가 빈칸일 경우)")
    @Test
    void king_move() {
        Board board = new Board(PieceFactory.createPieces());
        King king = King.Of("K", Position.Of(4, 4), true);
        assertThat(king.canMove(board.getBoard(), Position.Of(4, 5))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(5, 4))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(4, 3))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(3, 4))).isEqualTo(true);

        assertThat(king.canMove(board.getBoard(), Position.Of(3, 5))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(5, 5))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(3, 3))).isEqualTo(true);
        assertThat(king.canMove(board.getBoard(), Position.Of(5, 3))).isEqualTo(true);
    }

    @DisplayName("King은 상하좌우 모든 대각선 방향으로 1칸 이동할 수 있다.(목적지에 적의 기물이 있을 경우)")
    @Test
    void cant_move_king_if_different_color_piece_exist() {
        Board board = new Board(PieceFactory.createPieces());
        King king = King.Of("K", Position.Of(4, 4), true);
        Pawn pawn = Pawn.Of("P", Position.Of(4, 5), false);
        Pawn pawn2 = Pawn.Of("P", Position.Of(5, 3), false);
        board.put(pawn, Position.Of(4, 5));
        board.put(pawn2, Position.Of(5, 3));

        assertThat(king.canMove(board.getBoard(), Position.Of(4, 5))).isTrue();
        assertThat(king.canMove(board.getBoard(), Position.Of(5, 3))).isTrue();
    }

    @DisplayName("같은 편 말이 존재하는 위치로 이동할 수 없다.")
    @Test
    void cant_move_king_if_same_color_piece_exist() {
        Board board = new Board(PieceFactory.createPieces());
        King king = King.Of("K", Position.Of(4, 4), true);
        Pawn pawn = Pawn.Of("P", Position.Of(4, 5), true);
        Pawn pawn2 = Pawn.Of("P", Position.Of(5, 3), true);
        board.put(pawn, Position.Of(4, 5));
        board.put(pawn2, Position.Of(5, 3));

        assertThat(king.canMove(board.getBoard(), Position.Of(4, 5))).isFalse();
        assertThat(king.canMove(board.getBoard(), Position.Of(5, 3))).isFalse();
    }
}