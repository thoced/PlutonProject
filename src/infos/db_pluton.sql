-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 28 Janvier 2019 à 17:47
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_pluton`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_dossiers`
--

CREATE TABLE `t_dossiers` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(256) NOT NULL,
  `comment` text NOT NULL,
  `ref_id_sections` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_events`
--

CREATE TABLE `t_events` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `caller_number` varchar(24) DEFAULT NULL,
  `called_number` varchar(24) DEFAULT NULL,
  `caller_imsi` varchar(24) DEFAULT NULL,
  `called_imsi` varchar(24) DEFAULT NULL,
  `caller_imei` varchar(24) DEFAULT NULL,
  `called_imei` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_identites`
--

CREATE TABLE `t_identites` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `numero` varchar(32) NOT NULL,
  `nom` varchar(64) DEFAULT NULL,
  `prenom` varchar(64) DEFAULT NULL,
  `adresse` varchar(256) DEFAULT NULL,
  `num` varchar(16) DEFAULT NULL,
  `boite` varchar(16) DEFAULT NULL,
  `codepostal` varchar(16) DEFAULT NULL,
  `ville` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_link_identites_observations`
--

CREATE TABLE `t_link_identites_observations` (
  `ref_id_identites` bigint(20) UNSIGNED NOT NULL,
  `ref_id_observations` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_observations`
--

CREATE TABLE `t_observations` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `namefile` varchar(256) NOT NULL,
  `numero` varchar(64) NOT NULL,
  `comment` text NOT NULL,
  `ref_id_dossiers` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_sections`
--

CREATE TABLE `t_sections` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(64) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_users`
--

CREATE TABLE `t_users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `login` varchar(64) NOT NULL,
  `password` varchar(256) NOT NULL,
  `ref_id_sections` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `t_dossiers`
--
ALTER TABLE `t_dossiers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_foreign_ref_id_sections` (`ref_id_sections`);

--
-- Index pour la table `t_events`
--
ALTER TABLE `t_events`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `t_identites`
--
ALTER TABLE `t_identites`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_couple_numero_identite` (`numero`,`nom`,`prenom`,`adresse`) USING BTREE;

--
-- Index pour la table `t_link_identites_observations`
--
ALTER TABLE `t_link_identites_observations`
  ADD UNIQUE KEY `unique_couple_ref_ident_ref_obn` (`ref_id_identites`,`ref_id_observations`),
  ADD KEY `index_foreign_ref_id_identites` (`ref_id_identites`),
  ADD KEY `index_foreign_ref_id_observations` (`ref_id_observations`);

--
-- Index pour la table `t_observations`
--
ALTER TABLE `t_observations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_foreign_ref_id_dossiers` (`ref_id_dossiers`);

--
-- Index pour la table `t_sections`
--
ALTER TABLE `t_sections`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `t_users`
--
ALTER TABLE `t_users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_foreign_ref_id_sections` (`ref_id_sections`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `t_dossiers`
--
ALTER TABLE `t_dossiers`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_events`
--
ALTER TABLE `t_events`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_identites`
--
ALTER TABLE `t_identites`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_observations`
--
ALTER TABLE `t_observations`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_sections`
--
ALTER TABLE `t_sections`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_users`
--
ALTER TABLE `t_users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `t_dossiers`
--
ALTER TABLE `t_dossiers`
  ADD CONSTRAINT `t_dossiers_ibfk_1` FOREIGN KEY (`ref_id_sections`) REFERENCES `t_sections` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `t_link_identites_observations`
--
ALTER TABLE `t_link_identites_observations`
  ADD CONSTRAINT `t_link_identites_observations_ibfk_1` FOREIGN KEY (`ref_id_identites`) REFERENCES `t_identites` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_link_identites_observations_ibfk_2` FOREIGN KEY (`ref_id_observations`) REFERENCES `t_observations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `t_observations`
--
ALTER TABLE `t_observations`
  ADD CONSTRAINT `t_observations_ibfk_1` FOREIGN KEY (`ref_id_dossiers`) REFERENCES `t_dossiers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `t_users`
--
ALTER TABLE `t_users`
  ADD CONSTRAINT `t_users_ibfk_1` FOREIGN KEY (`ref_id_sections`) REFERENCES `t_sections` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
