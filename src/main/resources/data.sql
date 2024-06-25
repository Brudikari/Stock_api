CREATE TABLE stock (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       product_id INT NOT NULL,
                       remaining_stock INT UNSIGNED NOT NULL
);

INSERT INTO stock (product_id, remaining_stock) VALUES
                                                    (1, 100),
                                                    (2, 200),
                                                    (3, 150),
                                                    (4, 300),
                                                    (5, 250);