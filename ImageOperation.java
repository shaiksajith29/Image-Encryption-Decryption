import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class ImageOperation {

    // Method to calculate hash for data
    private static String calculateHash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data);

        // Convert hash bytes to a hexadecimal string for readability
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Method to encrypt image and display hash of original data
    public static void encryptImage(int key, String[] originalHashContainer) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] data = new byte[(int) file.length()];
                fis.read(data);

                // Store and display hash of original data before encryption
                String originalHash = calculateHash(data);
                originalHashContainer[0] = originalHash;
                JOptionPane.showMessageDialog(null, "Original Hash: " + originalHash);

                // Encrypt with XOR operation
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (data[i] ^ key);
                }

                // Save the encrypted data back to the file
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(data);
                }

                JOptionPane.showMessageDialog(null, "File encrypted successfully.");
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
    }

    // Method to decrypt image and verify hash
    public static void decryptImage(int key, String originalHash) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] data = new byte[(int) file.length()];
                fis.read(data);

                // Decrypt with XOR operation
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (data[i] ^ key);
                }

                // Calculate hash of decrypted data
                String decryptedHash = calculateHash(data);
                JOptionPane.showMessageDialog(null, "Decrypted Hash: " + decryptedHash);

                // Verify if the decrypted hash matches the original hash
                if (originalHash.equals(decryptedHash)) {
                    // Save the decrypted data back to the file
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        fos.write(data);
                    }
                    JOptionPane.showMessageDialog(null, "File decrypted successfully and hash verified.");
                } else {
                    JOptionPane.showMessageDialog(null, "File integrity check failed! Hashes do not match.");
                }

            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Operation");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Roboto", Font.BOLD, 20);

        JButton encryptButton = new JButton("Encrypt Image");
        encryptButton.setFont(font);

        JButton decryptButton = new JButton("Decrypt Image");
        decryptButton.setFont(font);

        JTextField textField = new JTextField(10);
        textField.setFont(font);

        // Container to store the hash of the original data after encryption
        final String[] originalHash = new String[1];

        encryptButton.addActionListener(e -> {
            String text = textField.getText();
            try {
                int key = Integer.parseInt(text);
                encryptImage(key, originalHash);  // Encrypt and store the original hash
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid key. Please enter a valid integer key.");
            }
        });

        decryptButton.addActionListener(e -> {
            String text = textField.getText();
            try {
                int key = Integer.parseInt(text);
                decryptImage(key, originalHash[0]);  // Decrypt and verify with stored original hash
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid key. Please enter a valid integer key.");
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(encryptButton);
        frame.add(decryptButton);
        frame.add(textField);
        frame.setVisible(true);
    }
}
