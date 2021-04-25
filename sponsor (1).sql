-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 03:47 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `sponsor`
--

CREATE TABLE `sponsor` (
  `buyer_id` int(11) NOT NULL,
  `f_name` varchar(50) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `company` varchar(255) NOT NULL,
  `job` varchar(255) NOT NULL,
  `phone` int(10) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sponsor`
--

INSERT INTO `sponsor` (`buyer_id`, `f_name`, `l_name`, `company`, `job`, `phone`, `mail`, `city`) VALUES
(7, 'Jaa', 'Shiva', 'Expo', 'QA', 1234567891, 'gh2gmail.com', 'Colombo'),
(9, 'Mathi', 'Kruthik', 'SLIIT', 'Student', 709087654, 'mathi@gmail.com', 'Colombo'),
(11, 'Liruckshana', 'Pushparaja', 'SLIIT', 'Student', 772200909, 'liru1@gmail.com', 'Galle'),
(12, 'Lakshika', 'Sivachandrabose', 'SLIIT', 'Student', 772200004, 'lakki@gmail.com', 'Matare'),
(13, 'Jeyashakthi', 'Sivalingam', 'IIT', 'Student', 723345789, 'lakki@gmail.com', 'Jaffna');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`buyer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `buyer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
