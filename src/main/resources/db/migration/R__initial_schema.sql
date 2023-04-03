CREATE TABLE users
(
    id   BIGINT,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    CONSTRAINT pk_users_id PRIMARY KEY (id),
    CONSTRAINT uq_users_name UNIQUE (username)
);

CREATE TABLE recipes
(
    id   BIGINT,
    name TEXT NOT NULL,
    CONSTRAINT pk_recipes_id PRIMARY KEY (id),
    CONSTRAINT uq_recipes_name UNIQUE (name)
);

CREATE TABLE products
(
    id       BIGINT,
    name     TEXT NOT NULL,
    measure  TEXT NOT NULL,
    category TEXT,
    price    NUMERIC,
    CONSTRAINT pk_products_id PRIMARY KEY (id),
    CONSTRAINT uq_products_name UNIQUE (name)
);

CREATE TABLE fridge_products
(
    id         BIGINT,
    product_id BIGINT NOT NULL,
    amount     REAL   NOT NULL,
    CONSTRAINT pk_fridge_products_id PRIMARY KEY (id),
    CONSTRAINT fk_fridge_products_product_id FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT uq_fridge_products_product_id UNIQUE (product_id)
);

CREATE TABLE ingredients
(
    id         BIGINT,
    product_id BIGINT NOT NULL,
    recipe_id  BIGINT NOT NULL,
    amount     REAL   NOT NULL,
    CONSTRAINT pk_ingredients_id PRIMARY KEY (id),
    CONSTRAINT fk_ingredients_product_id FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_ingredients_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes (id)
);

CREATE TABLE shop_receipts
(
    id         BIGINT  NOT NULL,
    user_id    TEXT    NOT NULL,
    status     TEXT    NOT NULL,
    sum        NUMERIC NOT NULL,
    CONSTRAINT pk_shop_receipts_id PRIMARY KEY (id),
    CONSTRAINT fk_shop_receipts_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE purchases
(
    id              BIGINT,
    shop_receipt_id BIGINT NOT NULL,
    product_id      BIGINT NOT NULL,
    amount          REAL   NOT NULL,
    product_price   NUMERIC,
    CONSTRAINT pk_purchases_id PRIMARY KEY (id),
    CONSTRAINT fk_purchases_product_id FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_purchases_shop_receipts_id FOREIGN KEY (product_id) REFERENCES shop_receipts (id)
);
