BEGIN;


DROP TABLE IF EXISTS products_tbl CASCADE;
create TABLE `products`.`products_tbl` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `price` INT UNSIGNED NULL,
  PRIMARY KEY (`id`));

    insert into `products`.`products_tbl` (`title`, `price`) values ('Apple', '100');
    insert into `products`.`products_tbl` (`title`, `price`) values ('Orange', '120');
    insert into `products`.`products_tbl` (`title`, `price`) values ('Tomato', '200');
    insert into `products`.`products_tbl` (`title`, `price`) values ('Potato', '30');
    insert into `products`.`products_tbl` (`title`, `price`) values ('Cucumber', '150');

COMMIT;