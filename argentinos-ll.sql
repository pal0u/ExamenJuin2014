-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 04 Juin 2014 à 11:22
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `argentinos-ll`
--
CREATE DATABASE IF NOT EXISTS `argentinos-ll` DEFAULT CHARACTER SET latin1 COLLATE latin1_bin;
USE `argentinos-ll`;

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

CREATE TABLE IF NOT EXISTS `arbitre` (
  `idArbitre` int(11) NOT NULL AUTO_INCREMENT,
  `Licence` int(11) NOT NULL,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idArbitre`),
  UNIQUE KEY `UK_Licence` (`Licence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `blessures`
--

CREATE TABLE IF NOT EXISTS `blessures` (
  `idBles` int(11) NOT NULL AUTO_INCREMENT,
  `Blessure` char(1) COLLATE latin1_bin NOT NULL,
  `Duree` date NOT NULL,
  `NumeroDAffiliation` int(11) NOT NULL,
  `idMatch` int(11) NOT NULL,
  PRIMARY KEY (`idBles`),
  KEY `FK_idMatch` (`idMatch`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `clubmatch`
--

CREATE TABLE IF NOT EXISTS `clubmatch` (
  `idMatch` int(11) NOT NULL,
  `idClub` int(11) NOT NULL,
  PRIMARY KEY (`idClub`,`idMatch`),
  KEY `FK_idClub` (`idClub`),
  KEY `FK_idMatch` (`idMatch`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `clubs`
--

CREATE TABLE IF NOT EXISTS `clubs` (
  `idClub` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` int(11) NOT NULL,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `idCq` int(11) NOT NULL,
  `idPres` int(11) NOT NULL,
  PRIMARY KEY (`idClub`),
  UNIQUE KEY `UK_Matricule` (`Matricule`),
  KEY `FK_idCq` (`idCq`),
  KEY `FK_idPres` (`idPres`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

CREATE TABLE IF NOT EXISTS `coach` (
  `idCoach` int(11) NOT NULL AUTO_INCREMENT,
  `AnneeDActivites` varchar(15) COLLATE latin1_bin NOT NULL,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idCoach`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `correspondantqualifie`
--

CREATE TABLE IF NOT EXISTS `correspondantqualifie` (
  `idCq` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Telephone` varchar(15) COLLATE latin1_bin NOT NULL,
  `e_mail` varchar(100) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idCq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `delegue`
--

CREATE TABLE IF NOT EXISTS `delegue` (
  `idDelegue` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Telephone` varchar(15) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idDelegue`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipecoachs`
--

CREATE TABLE IF NOT EXISTS `equipecoachs` (
  `idEquipe` int(11) NOT NULL,
  `idCoach` int(11) NOT NULL,
  PRIMARY KEY (`idCoach`,`idEquipe`),
  KEY `FK_idCoach` (`idCoach`),
  KEY `FK_idEquipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `equipedelegue`
--

CREATE TABLE IF NOT EXISTS `equipedelegue` (
  `idEquipe` int(11) NOT NULL,
  `idDelegue` int(11) NOT NULL,
  PRIMARY KEY (`idDelegue`,`idEquipe`),
  KEY `FK_idDelegue` (`idDelegue`),
  KEY `FK_idEquipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `equipematch`
--

CREATE TABLE IF NOT EXISTS `equipematch` (
  `idEquipe` int(11) NOT NULL,
  `idMatch` int(11) NOT NULL,
  PRIMARY KEY (`idEquipe`,`idMatch`),
  KEY `FK_idMatch` (`idMatch`),
  KEY `FK_idEquipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `equipes`
--

CREATE TABLE IF NOT EXISTS `equipes` (
  `idEquipe` int(11) NOT NULL AUTO_INCREMENT,
  `Annee` int(11) NOT NULL,
  `Serie` varchar(50) COLLATE latin1_bin NOT NULL,
  `idClub` int(11) NOT NULL,
  PRIMARY KEY (`idEquipe`),
  KEY `FK_idClub` (`idClub`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `joueurmatch`
--

CREATE TABLE IF NOT EXISTS `joueurmatch` (
  `idJoueurs` int(11) NOT NULL,
  `idMatch` int(11) NOT NULL,
  PRIMARY KEY (`idJoueurs`,`idMatch`),
  KEY `FK_idMatch` (`idMatch`),
  KEY `FK_idJoueurs` (`idJoueurs`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `joueurs`
--

CREATE TABLE IF NOT EXISTS `joueurs` (
  `idJoueurs` int(11) NOT NULL AUTO_INCREMENT,
  `DateDeNaissance` date NOT NULL,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `NumeroDAffiliation` int(11) NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idJoueurs`),
  UNIQUE KEY `UK_NumeroDAffiliation` (`NumeroDAffiliation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=2 ;

--
-- Contenu de la table `joueurs`
--

INSERT INTO `joueurs` (`idJoueurs`, `DateDeNaissance`, `Nom`, `NumeroDAffiliation`, `Prenom`) VALUES
(1, '1990-08-01', 'Dupond', 123545, 'Jean');

-- --------------------------------------------------------

--
-- Structure de la table `joueursmontants`
--

CREATE TABLE IF NOT EXISTS `joueursmontants` (
  `idJoueurs` int(11) NOT NULL,
  `idEquipe` int(11) NOT NULL,
  PRIMARY KEY (`idEquipe`,`idJoueurs`),
  KEY `FK_idEquipe` (`idEquipe`),
  KEY `FK_idJoueurs` (`idJoueurs`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Structure de la table `lieux`
--

CREATE TABLE IF NOT EXISTS `lieux` (
  `idLieux` int(11) NOT NULL AUTO_INCREMENT,
  `Adresse` varchar(100) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idLieux`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `matchs`
--

CREATE TABLE IF NOT EXISTS `matchs` (
  `idMatch` int(11) NOT NULL AUTO_INCREMENT,
  `Heure` varchar(5) COLLATE latin1_bin NOT NULL,
  `NumeroDeMatch` int(11) NOT NULL,
  `Score` varchar(4) COLLATE latin1_bin DEFAULT NULL,
  `Date` date NOT NULL,
  `idArbitre` int(11) NOT NULL,
  `idLieux` int(11) NOT NULL,
  PRIMARY KEY (`idMatch`),
  UNIQUE KEY `UK_NumeroDeMatch` (`NumeroDeMatch`),
  KEY `FK_idArbitre` (`idArbitre`),
  KEY `FK_idLieux` (`idLieux`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `president`
--

CREATE TABLE IF NOT EXISTS `president` (
  `idPres` int(11) NOT NULL AUTO_INCREMENT,
  `AnneesDActivite` varchar(15) COLLATE latin1_bin NOT NULL,
  `Nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `Prenom` varchar(50) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`idPres`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `suspensions`
--

CREATE TABLE IF NOT EXISTS `suspensions` (
  `idSus` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(4) COLLATE latin1_bin NOT NULL,
  `NumeroDAffiliation` int(11) NOT NULL,
  `idMatch` int(11) NOT NULL,
  PRIMARY KEY (`idSus`),
  KEY `FK_idMatch` (`idMatch`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `blessures`
--
ALTER TABLE `blessures`
  ADD CONSTRAINT `FK_bfngtslo7ihdry5lih5pw9ms8` FOREIGN KEY (`idMatch`) REFERENCES `matchs` (`idMatch`);

--
-- Contraintes pour la table `clubmatch`
--
ALTER TABLE `clubmatch`
  ADD CONSTRAINT `FK_6slea8s95wp0e4230mtausfso` FOREIGN KEY (`idMatch`) REFERENCES `matchs` (`idMatch`),
  ADD CONSTRAINT `FK_gju312ag9ivuekavy1tmsnuwc` FOREIGN KEY (`idClub`) REFERENCES `clubs` (`idClub`);

--
-- Contraintes pour la table `clubs`
--
ALTER TABLE `clubs`
  ADD CONSTRAINT `FK_md0brh8o68e178a0o0as5t21n` FOREIGN KEY (`idPres`) REFERENCES `president` (`idPres`),
  ADD CONSTRAINT `FK_ihf8iqegwbp0ox6t5duhfymnn` FOREIGN KEY (`idCq`) REFERENCES `correspondantqualifie` (`idCq`);

--
-- Contraintes pour la table `equipecoachs`
--
ALTER TABLE `equipecoachs`
  ADD CONSTRAINT `FK_e5b1g7rhyq46dd7pxgj4u2am1` FOREIGN KEY (`idEquipe`) REFERENCES `equipes` (`idEquipe`),
  ADD CONSTRAINT `FK_55qw84qa6a3n2m615e5uoxkf2` FOREIGN KEY (`idCoach`) REFERENCES `coach` (`idCoach`);

--
-- Contraintes pour la table `equipedelegue`
--
ALTER TABLE `equipedelegue`
  ADD CONSTRAINT `FK_ep56yhoeyqv61fyrxq1onptri` FOREIGN KEY (`idEquipe`) REFERENCES `equipes` (`idEquipe`),
  ADD CONSTRAINT `FK_beuwqnpsttn31xg35l9ltb8au` FOREIGN KEY (`idDelegue`) REFERENCES `delegue` (`idDelegue`);

--
-- Contraintes pour la table `equipematch`
--
ALTER TABLE `equipematch`
  ADD CONSTRAINT `FK_q7sm1mhg6u1slh7a82ed2wk7g` FOREIGN KEY (`idEquipe`) REFERENCES `equipes` (`idEquipe`),
  ADD CONSTRAINT `FK_hdta05ua0ffsr40nvd6kjo5gm` FOREIGN KEY (`idMatch`) REFERENCES `matchs` (`idMatch`);

--
-- Contraintes pour la table `equipes`
--
ALTER TABLE `equipes`
  ADD CONSTRAINT `FK_gal6buwkdinvyg9dqadiwo157` FOREIGN KEY (`idClub`) REFERENCES `clubs` (`idClub`);

--
-- Contraintes pour la table `joueurmatch`
--
ALTER TABLE `joueurmatch`
  ADD CONSTRAINT `FK_al8hgx8r9r5tcj8gntv708v0d` FOREIGN KEY (`idJoueurs`) REFERENCES `joueurs` (`idJoueurs`),
  ADD CONSTRAINT `FK_rkrtd8pd2hjjs9gju4aveywwv` FOREIGN KEY (`idMatch`) REFERENCES `matchs` (`idMatch`);

--
-- Contraintes pour la table `joueursmontants`
--
ALTER TABLE `joueursmontants`
  ADD CONSTRAINT `FK_alb860olosgrhmg8kn1do7cw5` FOREIGN KEY (`idJoueurs`) REFERENCES `joueurs` (`idJoueurs`),
  ADD CONSTRAINT `FK_40m3pad4hygy9sbrmwsawlema` FOREIGN KEY (`idEquipe`) REFERENCES `equipes` (`idEquipe`);

--
-- Contraintes pour la table `matchs`
--
ALTER TABLE `matchs`
  ADD CONSTRAINT `FK_i6plw5qi1dlg2altf5qth0jas` FOREIGN KEY (`idLieux`) REFERENCES `lieux` (`idLieux`),
  ADD CONSTRAINT `FK_9es8wbesp892lyn48mpsph0gh` FOREIGN KEY (`idArbitre`) REFERENCES `arbitre` (`idArbitre`);

--
-- Contraintes pour la table `suspensions`
--
ALTER TABLE `suspensions`
  ADD CONSTRAINT `FK_ab89p3l3mnx741ybfgnm6e118` FOREIGN KEY (`idMatch`) REFERENCES `matchs` (`idMatch`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
