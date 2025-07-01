# Image Encryption & Decryption Tool using Java Swing

A Java Swing desktop application to securely encrypt and decrypt image files using XOR encryption and SHA-256 hashing to ensure data integrity.

## 🚀 Features
- 🔐 Encrypts and decrypts image files using XOR cipher.
- 🔑 User-defined key input for symmetric encryption.
- 🧾 SHA-256 hash verification to check file integrity.
- 🖥️ Simple Java Swing GUI for user interaction.
- ✅ Zero data loss after decryption (tested on 50+ files).

## 🧰 Tech Stack
- Java
- Java Swing
- SHA-256 (MessageDigest)
- XOR Bitwise Encryption

## 📁 Folder Structure
```
ImageEncryptionTool/
│
├── ImageOperation.java         # Main Java file with GUI + logic
├── README.md                   # Documentation
└── /screenshots/               # (Optional) GUI or demo images
```

## 🛠️ How to Run
1. Make sure you have Java installed (JDK 8+).
2. Open terminal or command prompt in the project folder.
3. Compile the program:
   ```bash
   javac ImageOperation.java
   ```
4. Run the program:
   ```bash
   java ImageOperation
   ```

## 📌 Usage
- Enter an integer key in the textbox.
- Click "Encrypt Image" and select an image file → file is encrypted and SHA-256 hash is stored.
- Click "Decrypt Image" and select the same file → file is decrypted and hash is verified.

## ⚠️ Note
This project uses XOR encryption for demonstration purposes. For production-grade security, consider using AES with proper key management.

## 👨‍💻 Author
**Shaik Sajith**  
📧 shaiksajith29@gmail.com  
🌐 [GitHub Profile](https://github.com/shaiksajith29)

## 📝 License
This project is open-source under the [MIT License](https://opensource.org/licenses/MIT).
