INSERT INTO recipes (id, name) VALUES
(1, 'Salad with chicken and avocado'),
(2, 'Baked salmon'),
(3, 'Pesto pasta with vegetables');

INSERT INTO products (id, name, price, measure, category) VALUES
(1, 'Chicken breast', 12.99, 'kg', 'meat'),
(2, 'Avocado', 1.99, 'pcs', 'fruits'),
(3, 'Salmon fillet', 24.99, 'kg', 'fish'),
(4, 'Pasta', 2.99, 'pack', 'grocery'),
(5, 'Pesto sauce', 3.99, 'pack', 'sauce'),
(6, 'Broccoli', 1.49, 'kg', 'vegetables'),
(7, 'Cherry tomatoes', 1.99, 'pack', 'vegetables'),
(8, 'Parmesan cheese', 7.99, 'kg', 'dairy');

INSERT INTO fridge_products (id, product_id, amount) VALUES
(1, 1, 0.5),
(2, 2, 2),
(3, 3, 0.75),
(4, 6, 0.3),
(5, 7, 1);

INSERT INTO ingredients (id, product_id, recipe_id, amount) VALUES
(1, 1, 1, 0.5),
(2, 2, 1, 2),
(3, 6, 1, 0.3),
(4, 7, 1, 1),
(5, 3, 2, 0.75),
(6, 4, 3, 0.5),
(7, 5, 3, 1),
(8, 6, 3, 0.5),
(9, 7, 3, 0.5),
(10, 8, 3, 0.2);