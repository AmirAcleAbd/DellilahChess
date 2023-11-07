import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;

public class Board extends Application {

    static GridPane gRoot;
    Group qRoot = new Group();
    int cc = 2;
    int fromX, fromY, toX, toY;
    String startingeFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    static char[][] boardPosi = new char[8][8];
    String[] gameCondition = fenInterpreter(startingeFen);
    String castling = gameCondition[2];
    String enPassant = gameCondition[3];
    int drawCounter = Integer.parseInt(gameCondition[4]);
    int movesCounter = Integer.parseInt(gameCondition[5]);
    ImageView[][] pawnPositions = returnImages(gameCondition[0]);

    public String[] getGameCondition() {
        return gameCondition;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage qStage) throws Exception {

        Scene qScene = new Scene(qRoot, 800, 800, Color.PINK);
        qStage.setTitle("Del Che Eng");
        qStage.setResizable(false);
        Image icon = new Image("icois/iconC.png");
        qStage.getIcons().add(icon);

        createChessBoard();
        qRoot.getChildren().add(gRoot);

        populateBoardPosi(gameCondition[0]);

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (pawnPositions[rank][file] != null) {
                    //use these images to create an action event for each image
                    qRoot.getChildren().add(pawnPositions[rank][file]);
                }
            }
        }

        qScene.setOnMousePressed(this::mousePressed);

        qStage.setScene(qScene);
        qStage.show();
    }

    public static String[] fenInterpreter(String fen) {
        return fen.split(" ");
    }

    public void populateBoardPosi(String position) {

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                boardPosi[rank][file] = 'e';
            }
        }

        int rank = 0;
        int file = 0;

        for (int i = 0; i < position.length(); i++) {
            char piece = position.charAt(i);
            if (piece == '/') {
                rank++;
                file = 0;
            } else if (Character.isDigit(piece)) {
                file += Character.getNumericValue(piece);
            } else {
                boardPosi[rank][file] = piece;
                file++;
            }
        }
    }

    public ImageView[][] returnImages(String posi) {
        ImageView[][] pawnPositions = new ImageView[8][8];
        int rank = 0;
        int file = 0;
        for (int i = 0; i < posi.length(); i++) {
            char piece = posi.charAt(i);
            if (piece == '/') {
                rank++;
                file = 0;
            } else if (Character.isDigit(piece)) {
                file += Character.getNumericValue(piece);
            } else {
                Image whichPiece = Pieces.pieceImage(piece);
                ImageView pieceImage = new ImageView(whichPiece);
                pieceImage.setFitHeight(75);
                pieceImage.setFitWidth(75);
                pieceImage.setX(100 + (file * 75));
                pieceImage.setY(100 + (rank * 75));
                pawnPositions[rank][file] = pieceImage;
                file++;
            }
        }
        return pawnPositions;
    }

    public void createChessBoard() {

        gRoot = new GridPane();
        gRoot.setGridLinesVisible(true);
        gRoot.setPrefSize(800, 800);
        gRoot.setHgap(0);
        gRoot.setVgap(0);
        gRoot.setGridLinesVisible(true);
        gRoot.setTranslateX(100);
        gRoot.setTranslateY(100);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(75, 75);
                if ((i + j) % 2 == 0) {
                    rect.setFill(Color.WHITE);
                } else {
                    rect.setFill(Color.BROWN);
                }
                gRoot.add(rect, i, j);
            }
        }
    }


    public String fenGenerator(char[][] pawnPositions, String castling, String enPassant, int drawCounter, int movesCounter) {
        String fen = "";
        int emptyCounter = 0;
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (pawnPositions[rank][file] == 'e') {
                    emptyCounter++;
                } else {
                    if (emptyCounter != 0) {
                        fen += emptyCounter;
                        emptyCounter = 0;
                    }
                    fen += pawnPositions[rank][file];
                }
            }
            if (emptyCounter != 0) {
                fen += emptyCounter;
                emptyCounter = 0;
            }
            if (rank != 7) {
                fen += "/";
            }
        }
        fen += " w " + castling + " " + enPassant + " " + drawCounter + " " + movesCounter;
        return fen;
    }

    public void mousePressed(MouseEvent event) {
        if (cc % 2 == 0) {
            fromX = (int) ((event.getX() - 100) / 75);
            fromY = (int) (((event.getY()) - 100) / 75);
            System.out.println("fromX: " + fromX + " fromY: " + fromY);
            cc++;
        } else {
            toX = (int) ((event.getX()) - 100) / 75;
            toY = (int) (((event.getY()) - 100) / 75);
            System.out.println("fromX1: " + toX + " fromY1: " + toY);
            cc++;
        }

        if (cc % 2 == 0) {
            if (boardPosi[fromY][fromX] != 'e') {
                boolean isSameColor = false;
                char from = boardPosi[fromY][fromX];
                char to = boardPosi[toY][toX];
                if ((Character.isUpperCase(from) && Character.isUpperCase(to)) || Character.isLowerCase(from) && Character.isLowerCase(to)) {
                    isSameColor = true;
                }
                //! valid moves works for some reason
                if(!validMove(fromX, fromY, toX , toY )){
                    if (!isSameColor || to == 'e') {
                        qRoot.getChildren().remove(pawnPositions[fromY][fromX]);
                        //boardPosi[fromY][fromX] = 'e';
                        pawnPositions[fromY][fromX].setX(toX * 75 + 100);
                        pawnPositions[fromY][fromX].setY(toY * 75 + 100);
                        ImageView img = pawnPositions[fromY][fromX];

                        if (boardPosi[toY][toX] != 'e') {
                            qRoot.getChildren().remove(pawnPositions[toY][toX]);
                            pawnPositions[toY][toX] = img;
                            qRoot.getChildren().add(pawnPositions[toY][toX]);
                            boardPosi[toY][toX] = boardPosi[fromY][fromX];
                            boardPosi[fromY][fromX] = 'e';
                        } else {
                            pawnPositions[toY][toX] = img;
                            qRoot.getChildren().add(pawnPositions[toY][toX]);
                            boardPosi[toY][toX] = boardPosi[fromY][fromX];
                            boardPosi[fromY][fromX] = 'e';
                        }
                    }
                }
                /*if(!isSameColor || to == 'e') {
                    qRoot.getChildren().remove(pawnPositions[fromY][fromX]);
                    //boardPosi[fromY][fromX] = 'e';
                    pawnPositions[fromY][fromX].setX(toX * 75 + 100);
                    pawnPositions[fromY][fromX].setY(toY * 75 + 100);
                    ImageView img = pawnPositions[fromY][fromX];

                    if (boardPosi[toY][toX] != 'e') {
                        qRoot.getChildren().remove(pawnPositions[toY][toX]);
                        pawnPositions[toY][toX] = img;
                        qRoot.getChildren().add(pawnPositions[toY][toX]);
                        boardPosi[toY][toX] = boardPosi[fromY][fromX];
                        boardPosi[fromY][fromX] = 'e';
                    } else {
                        pawnPositions[toY][toX] = img;
                        qRoot.getChildren().add(pawnPositions[toY][toX]);
                        boardPosi[toY][toX] = boardPosi[fromY][fromX];
                        boardPosi[fromY][fromX] = 'e';
                    }
                }*/
            }
        }
    }

    public static boolean validMove(int fromX, int fromY, int toX, int toY){

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
                if(fromY < 5){
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
                if(fromY > 1){
                    if(fromY - toY == 1) {
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }
}

