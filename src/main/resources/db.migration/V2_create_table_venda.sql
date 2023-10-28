CREATE TABLE Venda (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       produto_id INT NOT NULL,
                       quantidade INT NOT NULL,
                       valorTotal DOUBLE NOT NULL,
                       FOREIGN KEY (produto_id) REFERENCES produto(id)
);