-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2020 at 05:40 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lat_rizkybaru`
--

-- --------------------------------------------------------

--
-- Table structure for table `beli_tanki`
--

CREATE TABLE `beli_tanki` (
  `id_beli` int(12) NOT NULL,
  `harga_tanki` varchar(25) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `beli_tanki`
--

INSERT INTO `beli_tanki` (`id_beli`, `harga_tanki`, `tanggal`) VALUES
(26, '120000', '2020-01-22'),
(27, '120000', '2020-01-22'),
(28, '120000', '2020-01-22'),
(29, '120000', '2020-01-22');

-- --------------------------------------------------------

--
-- Table structure for table `harga_galon`
--

CREATE TABLE `harga_galon` (
  `id_harga` int(11) NOT NULL,
  `harga` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `harga_galon`
--

INSERT INTO `harga_galon` (`id_harga`, `harga`) VALUES
(1, 500);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `ID` int(11) NOT NULL,
  `Tgl` varchar(25) NOT NULL,
  `Galon_Terjual` int(25) DEFAULT NULL,
  `Jumlah` int(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`ID`, `Tgl`, `Galon_Terjual`, `Jumlah`) VALUES
(30, '2020-01-17', 2, 7000),
(41, '2020-01-30', 5, 25000),
(42, '2020-01-30', 111, 555000),
(43, '2020-01-31', 15, 75000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'admin', 'adminair');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beli_tanki`
--
ALTER TABLE `beli_tanki`
  ADD PRIMARY KEY (`id_beli`);

--
-- Indexes for table `harga_galon`
--
ALTER TABLE `harga_galon`
  ADD PRIMARY KEY (`id_harga`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `beli_tanki`
--
ALTER TABLE `beli_tanki`
  MODIFY `id_beli` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `harga_galon`
--
ALTER TABLE `harga_galon`
  MODIFY `id_harga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
