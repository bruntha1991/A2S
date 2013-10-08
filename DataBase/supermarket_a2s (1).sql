-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 08, 2013 at 04:01 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `supermarket_a2s`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidate_data`
--

CREATE TABLE IF NOT EXISTS `candidate_data` (
  `id` varchar(20) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `qualification` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `applied_job` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidate_data`
--


-- --------------------------------------------------------

--
-- Table structure for table `customer_data`
--

CREATE TABLE IF NOT EXISTS `customer_data` (
  `loyaltycard` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `points` double DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`loyaltycard`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_data`
--


-- --------------------------------------------------------

--
-- Table structure for table `customer_history`
--

CREATE TABLE IF NOT EXISTS `customer_history` (
  `date_and_time` varchar(45) DEFAULT NULL,
  `loayaltycard_id` varchar(20) DEFAULT NULL,
  `total_payment` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_history`
--


-- --------------------------------------------------------

--
-- Table structure for table `employee_data`
--

CREATE TABLE IF NOT EXISTS `employee_data` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `post` varchar(100) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `basic_salary` double DEFAULT NULL,
  `appointment_date` date DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_data`
--


-- --------------------------------------------------------

--
-- Table structure for table `product_group`
--

CREATE TABLE IF NOT EXISTS `product_group` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_group`
--


-- --------------------------------------------------------

--
-- Table structure for table `product_subgroup`
--

CREATE TABLE IF NOT EXISTS `product_subgroup` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_subgroup`
--


-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE IF NOT EXISTS `product_type` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `units` int(11) DEFAULT NULL,
  `bottomlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_type`
--

INSERT INTO `product_type` (`id`, `name`, `price`, `units`, `bottomlevel`) VALUES
('1000', 'abc', 100, -2, NULL),
('1001', 'bbb', 50, -78, NULL),
('1005', 'lkj', 56, 55, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `sales_history`
--

CREATE TABLE IF NOT EXISTS `sales_history` (
  `date_time` datetime NOT NULL,
  `product_id` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `noOfUnits` int(11) NOT NULL,
  `date` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_history`
--

INSERT INTO `sales_history` (`date_time`, `product_id`, `product_name`, `noOfUnits`, `date`, `month`, `year`) VALUES
('2013-10-08 01:33:19', '1001', 'bbb', 10, 8, 10, 2013),
('2013-10-08 01:33:19', '1000', 'abc', 5, 8, 10, 2013),
('2013-10-08 01:35:38', '1005', 'lkj', 5, 8, 10, 2013),
('2013-10-08 01:36:22', '1001', 'bbb', 10, 8, 10, 2013),
('2013-10-08 01:36:22', '1001', 'bbb', 1, 8, 10, 2013),
('2013-10-08 03:13:05', '1001', 'bbb', 12, 8, 10, 2013),
('2013-10-08 03:19:22', '1001', 'bbb', 10, 8, 10, 2013),
('2013-10-08 03:40:25', '1001', 'bbb', 10, 8, 10, 2013),
('2013-10-08 03:41:39', '1001', 'bbb', 2, 8, 10, 2013),
('2013-10-08 03:45:32', '1001', 'bbb', 12, 8, 10, 2013),
('2013-10-08 03:47:30', '1000', 'abc', 5, 8, 10, 2013),
('2013-10-08 03:48:10', '1000', 'abc', 2, 8, 10, 2013);

-- --------------------------------------------------------

--
-- Table structure for table `supplier_data`
--

CREATE TABLE IF NOT EXISTS `supplier_data` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `address` varchar(200) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_data`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
