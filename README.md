# passcrypt
***
Passcrypt is a password manager desktop application that encrypts passwords with Data Encryption Standard(DES) and stores them.

![Passcrypt] (https://drive.google.com/file/d/1MAERVEUwbpAJccTLSl_qYEynAMwCFeUP/view?usp=drive_link)

## Techstack
Passcrypt is made using NetBeans IDE and Core Java.

## Usecase
For securely saving multiple passwords using a single or multiple master keys.

## Useage
1) Enter your account name, password and a master password, then press Encrypt.
2) The application encrypts the password using Data Encryption Standard(DES) and stores it.
3) Stored passwords can be seen in the list.
4) To retrieve your password, enter the unique id of the account and enter the same master key used afor encryption, then press Decrypt.
5) The the password is then decrypted and plaintext password becomes visible.

## Under the hood
* Passcrypt uses the Data Encryption Standard(DES) algorithm present in 'DesProgram.java' to generate a 56 bit encryption key using the provided password.
* The encyption key is used to encrypt the password of the given account which is then stored as an entry in a csv file.
* The entries are alloted a sequential unique IDs which are used to uniquely identify each account-password.
* IDs, Account Name and encrypted passwords are written to an external file './data.csv'.
* Metadata about the passwords is written to './metadata.txt';

## Sources
1. [Data Encryption Standard (DES) Code in Java](https://medium.com/@amit28amical/data-encryption-standard-des-code-in-java-4a45ad692bae)
