-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 10:49 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `project_Id` int(11) NOT NULL,
  `project_code` char(7) NOT NULL,
  `project_category` varchar(255) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `project_descrip` varchar(255) NOT NULL,
  `project_price` decimal(9,2) NOT NULL,
  `no_of_projects` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`project_Id`, `project_code`, `project_category`, `project_name`, `project_descrip`, `project_price`, `no_of_projects`) VALUES
(54, 'pro0001', 'Education', 'School', 'Managing the', '200.00', 3),
(55, 'pro3455', 'Education', 'School Management', 'Managing the School', '9999.99', 3),
(56, 'pro0005', 'bhgghg', 'Bankers', 'nbnbbn', '9999.99', 2),
(58, 'PRO1001', 'Education hghgggh', 'School Management hghghghg', 'Managing the School hghghgh', '9999.99', 2),
(59, 'pro0005', 'bhgghg', 'Bankers', 'nbnbbn', '9999.99', 2),
(60, 'pro6767', 'hghhghgh', 'hjhjhj', 'njhjh', '9999.99', 5),
(61, 'pro0005', 'bhgghg', 'Bankers', 'nbnbbn', '9999.99', 2),
(65, 'PRO1001', 'jhjhj', 'School Management hghghghg', 'Managing the School hghghgh', '9999.99', 2),
(69, 'PRO1234', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(70, 'PRO1234', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(71, 'PRO1234', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(72, 'pro0000', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(73, '1245671', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(74, '124567j', 'School', 'School dfdgdg', 'ghhgh hhgg', '9999.99', 4),
(76, 'pro0987', 'School', 'School dfdgdg', 'ghhgh hhgg', '10000.00', 4),
(77, 'pro0987', 'School', 'School dfdgdg', 'ghhgh hhgg', '1000000.00', 4),
(78, 'pro5678', 'Schoolsss', 'School dfdgdg', 'ghhgh hhgg', '1000.00', 4),
(79, 'pro0004', 'Schoolsss', 'School dfdgdg', 'ghhgh hhgg', '100000.00', 4),
(81, 'pro7676', 'hotel', 'Mini hotel', 'hotel management', '30000.00', 4),
(83, '1234567', 'School', 'School dfdgdg', 'ghhgh hhgg', '10000.00', 4),
(84, '0008453', 'Schooltttttt', 'School dfdgdg', 'ghhgh hhgg', '10000.00', 4),
(85, 'pro0005', 'Education', 'School', 'Recording and tracking the School details ', '30000.00', 9),
(86, 'pro0001', 'Agriculture', 'Agri Grow', 'Production of organic agricultural products', '25000.00', 7),
(87, 'pro0001', 'Agriculture', 'Agri Grow', 'Production of organic agricultural products', '25000.00', 7),
(88, 'PRO1234', 'School', 'School dfdgdg', 'ghhgh hhgg', '10000.00', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`project_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `project_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
