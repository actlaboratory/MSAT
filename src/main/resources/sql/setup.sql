USE msat;

CREATE TABLE `incoming_server_setting` (
    `ID` int unsigned NOT NULL AUTO_INCREMENT,
    `server_type` char(20) not null,
    `provider_name` char(150) not null,
    `host` VARCHAR(150) not null,
    `port` SMALLINT unsigned not null,
    `user_name` varchar(255) not null,
    `ssl` bit not null,
    `description` text,
    `help_url` varchar(200),
    `source` char(100) not null,
    `source_url` char(200),
    `updated_date` date not null,
    PRIMARY KEY(`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `incoming_server_domain`(
    `ID` int unsigned NOT NULL AUTO_INCREMENT,
    `domain` char(255) not null,
    `setting_id` int unsigned not null,
    `updated_date` date not null,
    PRIMARY KEY(`ID`),
    FOREIGN KEY (`setting_id`) REFERENCES `incoming_server_setting` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `outgoing_server_setting` (
    `ID` int unsigned NOT NULL AUTO_INCREMENT,
    `provider_name` char(150) not null,
    `host` VARCHAR(150) not null,
    `port` SMALLINT unsigned not null,
    `user_name` varchar(255) not null,
    `ssl` bit not null,
    `description` text,
    `help_url` varchar(200),
    `source` char(100) not null,
    `source_url` char(255),
    `updated_date` date not null,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `outgoing_server_domain` (
    `ID` int unsigned NOT NULL AUTO_INCREMENT,
    `domain` char(255) not null,
    `setting_id` int unsigned not null,
    `updated_date` date not null,
    PRIMARY KEY(`ID`),
    FOREIGN KEY (`setting_id`) REFERENCES `outgoing_server_setting` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
