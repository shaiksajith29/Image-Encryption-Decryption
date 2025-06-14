# Image-Encryption-Decryption
ava app for image encryption, decryption, and integrity check via hashing.
# Image Encryption and Decryption Tool (Java, Swing GUI)

This is a simple Java-based GUI application for encrypting and decrypting image files using XOR cipher with a numeric key. The app also uses SHA-256 hashing to verify the integrity of the decrypted file.

## Features

- Select any image file for encryption/decryption using a file chooser.
- Encrypt the image using XOR operation with a user-defined key.
- Generate and display SHA-256 hash of the original image before encryption.
- Decrypt the image and verify the decrypted file's integrity using the original hash.
- Intuitive and user-friendly GUI built with Java Swing.

## Technologies Used

- Java
- Java Swing for GUI
- SHA-256 hashing from `java.security`
- File I/O operations

## How It Works

1. **Encrypt Image**:
   - Enter a numeric key.
   - Select an image file.
   - The image data is encrypted using XOR with the given key.
   - SHA-256 hash of the original image is calculated and stored.
   - Encrypted image is saved in place.

2. **Decrypt Image**:
   - Enter the same numeric key.
   - Select the encrypted image file.
   - The file is decrypted using XOR.
   - SHA-256 hash of the decrypted image is compared with the original hash.
   - If hashes match, file is saved and integrity is confirmed.

## How to Run

1. Make sure you have Java 8 or later installed.
2. Compile the program:
   ```bash
   javac ImageOperation.java
