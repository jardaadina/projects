import javax.swing.*;

public class Xsi0App {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            Xsi0Model model = new Xsi0Model();
            Xsi0View view = new Xsi0View();
            new Xsi0Controller(model, view);
        });
    }
}
