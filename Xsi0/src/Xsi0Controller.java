import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Xsi0Controller {
    private Xsi0Model model;
    private Xsi0View view;

    private char currentPlayer;

    Xsi0Controller(Xsi0Model model, Xsi0View view)
    {
        this.model = model;
        this.view = view;
        this.currentPlayer = 'X';
        initializeGame();
    }

    private void initializeGame()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                view.setButtonText(i, j, model.getBoard()[i][j]);
                view.setButtonEnabled(i, j, true);
                int finalI = i;
                int finalJ = j;
                view.setCellColor(i, j, Color.CYAN);
                view.addCellClickListener(i, j, new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleCellClick(finalI, finalJ);
                    }
                });
            }
        }
        view.setSize(400, 400);
        view.setLocationRelativeTo(null);
    }

    private void handleCellClick(int row, int col)
    {
        if (model.getBoard()[row][col] == ' ')
        {
            if (model.makeMove(row, col, currentPlayer))
            {
                updateView();
                if (!checkGameEnd())
                {
                    switchPlayer();
                }
            }
        }
    }

    private void switchPlayer()
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void updateView()
    {
        char[][] board = model.getBoard();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                view.setButtonText(i, j, board[i][j]);
                view.setButtonEnabled(i, j, board[i][j] == ' ');
            }
        }
    }

    private boolean checkGameEnd()
    {
        char winner = model.checkForWinner();
        if (winner != ' ' || model.isBoardFull())
        {
            showGameResult(winner);
            return true;
        }
        return false;
    }

    private void showGameResult(char winner)
    {
        if (winner == 'X')
        {
            JOptionPane.showMessageDialog(view, "X castiga!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else if (winner == 'O')
        {
            JOptionPane.showMessageDialog(view, "O castiga!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(view, "REMIZA!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
        resetGame();
    }
    private void resetGame()
    {
        model.initializeBoard();
        updateView();
    }
}
