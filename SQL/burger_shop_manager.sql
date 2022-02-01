-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2022 at 10:23 AM
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
(1, 'Egg Burger', 0, 130),
(2, 'Beef Burger', 0, 120),
(3, 'Chicken Burger', 0, 100),
(4, 'Vegitable Burger', 0, 90),
(5, 'BBQ Burger', 0, 140),
(6, 'Cheese Burger', 0, 115),
(7, 'Double Cheese Burger', 0, 190),
(8, 'Mushroom Burger', 0, 150),
(9, 'Fish Burger', 0, 145),
(10, 'Hot Dog', 0, 80),
(11, 'Tandori Burger', 0, 170),
(12, 'Baffalo Burger', 0, 200);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `C_ID` int(5) NOT NULL,
  `Item-1` int(3) DEFAULT NULL,
  `Item-2` int(3) DEFAULT NULL,
  `Item-3` int(3) DEFAULT NULL,
  `Item-4` int(11) DEFAULT NULL,
  `Item-5` int(11) DEFAULT NULL,
  `Item-6` int(11) DEFAULT NULL,
  `Item-7` int(11) DEFAULT NULL,
  `Item-8` int(11) DEFAULT NULL,
  `Item-9` int(11) DEFAULT NULL,
  `Item-10` int(11) DEFAULT NULL,
  `Item-11` int(11) DEFAULT NULL,
  `Item-12` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`C_ID`, `Item-1`, `Item-2`, `Item-3`, `Item-4`, `Item-5`, `Item-6`, `Item-7`, `Item-8`, `Item-9`, `Item-10`, `Item-11`, `Item-12`) VALUES
(101, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
(102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(103, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
(104, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
(105, 5, 3, 4, 1, 2, 3, 2, 1, 4, 0, 2, 5),
(107, 5, 3, 4, 1, 2, 3, 2, 1, 4, 0, 2, 5),
(108, 5, 3, 4, 1, 2, 3, 2, 1, 4, 0, 2, 5),
(109, 5, 3, 4, 1, 2, 3, 2, 1, 4, 0, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Mobile` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `UserStatus` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`Name`, `Email`, `Mobile`, `Password`, `UserStatus`) VALUES
('Iftekhar', 'iftekharifat007@gmail.com', '01782565398', 'bB_12345', 'buyer'),
('Sajid Abdullah', 'sajidabdullah@gmail.com', '01722100839', 'aA_12345', 'admin'),
('Jehadul Islam Mony ', 'mony@gmail.com', '01712312312', 'Mo_12345', 'seller'),
('Biggo Bushon Da', 'bushon@gmail.com', '01712345678', 'Bo@1234', 'seller'),
('Shafkat', 'shafkat@gmail.com', '01632165478', 'Sh@1234', 'pending'),
('Humayra', 'himu@gmail.com', '01712456789', 'Hi_1234', 'pending'),
('Rifat', 'rifat@gmail.com', '01756498790', 'Rif@123', 'buyer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `burger_items`
--
ALTER TABLE `burger_items`
  ADD PRIMARY KEY (`Item No.`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`C_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `C_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
