-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2022 at 07:17 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `burger_shop_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `burger_items`
--

CREATE TABLE `burger_items` (
  `Item No.` int(5) NOT NULL,
  `Item Name` varchar(25) NOT NULL,
  `Quantity` int(50) DEFAULT NULL,
  `Price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `burger_items`
--

INSERT INTO `burger_items` (`Item No.`, `Item Name`, `Quantity`, `Price`) VALUES
(1, 'Egg Burger', 90, 4),
(2, 'Beef Burger', 10, 120),
(3, 'Chicken Burger', 20, 100),
(4, 'Vegitable Burger', 50, 90),
(5, 'BBQ Burger', 40, 140),
(6, 'Cheese Burger', 60, 115),
(7, 'Double Cheese Burger', 70, 190),
(8, 'Mushroom Burger', 20, 150),
(9, 'Fish Burger', 50, 145),
(10, 'Hot Dog', 10, 80),
(11, 'Tandori Burger', 50, 170),
(12, 'Baffalo Burger', 40, 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `burger_items`
--
ALTER TABLE `burger_items`
  ADD PRIMARY KEY (`Item No.`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
