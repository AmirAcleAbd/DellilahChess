import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Pieces {


    /*public static boolean validMove(char[][] boardPosi, int fromX, int fromY, int toX, int toY){

        switch (boardPosi[fromX][fromY]){
            case 'K':
            case 'k':
                if(Math.abs(fromX-toX) <= 1 && Math.abs(fromY-toY) <= 1){
                    return true;
                }else{
                    return false;
                }
            case 'Q':
            case 'q':
                if(fromX - toX == 0 || fromY - toY == 0 || Math.abs(fromX-toX) == Math.abs(fromY-toY)) {
                    return true;
                }else{
                    return false;
                }
            case 'B':
            case 'b':
                if(Math.abs(fromX-toX) == Math.abs(fromY-toY)){
                    return true;
                }else{
                    return false;
                }
            case 'R':
            case 'r':
                if(fromX - toX == 0 || fromY - toY == 0){
                    return true;
                }else{
                    return false;
                }
            case 'N':
            case 'n':
                if(Math.abs(fromX-toX) == 2 && Math.abs(fromY-toY) == 1 || Math.abs(fromX-toX) == 1 && Math.abs(fromY-toY) == 2) {
                    return true;
                }
                break;
            case 'P':
                if(fromY == 6){
                    if(fromY - toY == 1 || fromY - toY == 2) {
                        return true;
                    }
                }
                if(fromY == 5){
                    if(fromY - toY == 1) {
                        return true;
                    }
                }
                break;
            case 'p':
                if(fromY == 1){
                    if(fromY - toY == 1 || fromY - toY == 2) {
                        return true;
                    }
                }
                if(fromY == 2){
                    if(fromY - toY == 1) {
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }*/


    public static Image pieceImage(char para){

        Image whichPiece = null;

        switch (para) {
            case 'k' -> whichPiece = new Image("icois/bK.png");
            case 'q' -> whichPiece = new Image("icois/bQ.png");
            case 'b' -> whichPiece = new Image("icois/bB.png");
            case 'n' -> whichPiece = new Image("icois/bN.png");
            case 'r' -> whichPiece = new Image("icois/bR.png");
            case 'p' -> whichPiece = new Image("icois/bP.png");
            case 'K' -> whichPiece = new Image("icois/wK.png");
            case 'Q' -> whichPiece = new Image("icois/wQ.png");
            case 'B' -> whichPiece = new Image("icois/wB.png");
            case 'N' -> whichPiece = new Image("icois/wN.png");
            case 'R' -> whichPiece = new Image("icois/wR.png");
            case 'P' -> whichPiece = new Image("icois/wP.png");
        }

        if(whichPiece == null){
            whichPiece = new Image("icois/iconC.png");
        }

        return whichPiece;
    }
}
