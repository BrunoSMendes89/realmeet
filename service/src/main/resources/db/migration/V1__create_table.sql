CREATE TABLE `room` (
   `id` BIGINT NOT NULL,
   `name` VARCHAR(20) NULL,
   `seats` INT NULL,
   `active` TINYINT NULL,
   PRIMARY KEY (`id`)
);