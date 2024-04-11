import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class Xsi0View extends JFrame
{
    private JButton[][] buttons;

    Xsi0View()
    {
        setTitle("X si 0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
                buttons[i][j].setEnabled(false);
                add(buttons[i][j]);
            }
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void setButtonEnabled(int row, int col, boolean enabled) {
        buttons[row][col].setEnabled(enabled);
    }

    void setButtonText(int row, int col, char text) {
        buttons[row][col].setText(String.valueOf(text));
    }

    void addCellClickListener(int row, int col, ActionListener listener)
    {
        buttons[row][col].addActionListener(listener);
    }

    public void setCellColor(int row, int col, Color color) {
        buttons[row][col].setBackground(color);
    }
}
