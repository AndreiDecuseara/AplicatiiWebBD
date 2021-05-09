INSERT INTO users (username, password, enabled)
values ('guest',
        '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
        1);
INSERT INTO users (username, password, enabled)
values ('customer',
        '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
        1);

INSERT INTO `tags` (`id`, `color`, `name`) VALUES ('1', '#32a852', 'Green Tag');
INSERT INTO `tags` (`id`, `color`, `name`) VALUES ('2', '#ff1205', 'Red Tag');
INSERT INTO `tags` (`id`, `color`, `name`) VALUES ('3', '#4287f5', 'Blue Tag');
INSERT INTO `tags` (`id`, `color`, `name`) VALUES ('4', '#fff700', 'Yellow Tag');

INSERT INTO `items` (`id`, `code`, `name`, `price`, `status`, `user_id`) VALUES ('1', '23423423', 'Item 1 bread', '1.3', 'IN', '1');
INSERT INTO `item_tag` (`item_id`, `tag_id`) VALUES ('1', '2');
INSERT INTO `item_tag` (`item_id`, `tag_id`) VALUES ('1', '1');
INSERT INTO `item_tag` (`item_id`, `tag_id`) VALUES ('1', '3');
INSERT INTO `items` (`id`, `code`, `name`, `price`, `status`, `user_id`) VALUES ('2', '4525453', 'Item 2 cat', '765', 'OUT', '2');
INSERT INTO `item_tag` (`item_id`, `tag_id`) VALUES ('2', '1');
INSERT INTO `item_tag` (`item_id`, `tag_id`) VALUES ('2', '4');
INSERT INTO `infos` (`id`, `country`, `description`, `items_id`) VALUES ('1', 'Romania', 'The most important food for population', '1');
INSERT INTO `infos` (`id`, `country`, `description`, `items_id`) VALUES ('2', 'Germany', 'A simple cat to sell', '2');

INSERT INTO `orders` (`id`, `timestamp`, `buyer_id`, `items_id`) VALUES ('1', '2021-05-18 13:04:43.000000', '1', '1');
INSERT INTO `orders` (`id`, `timestamp`, `buyer_id`, `items_id`) VALUES ('2', '2021-05-17 13:04:43.000000', '2', '2');
INSERT INTO `orders` (`id`, `timestamp`, `buyer_id`, `items_id`) VALUES ('3', '2021-05-16 13:04:43.000000', '1', '2');
INSERT INTO `orders` (`id`, `timestamp`, `buyer_id`, `items_id`) VALUES ('4', '2021-05-15 13:04:43.000000', '2', '1');