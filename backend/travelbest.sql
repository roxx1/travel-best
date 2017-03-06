--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: travel_guide
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO travel_guide;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE orders (
    id bigint NOT NULL,
    pay_date timestamp without time zone,
    rejected boolean,
    returned boolean,
    payment_system_id bigint,
    trip_id bigint,
    user_id bigint
);


ALTER TABLE orders OWNER TO travel_guide;

--
-- Name: payment_systems; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE payment_systems (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE payment_systems OWNER TO travel_guide;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE roles (
    id bigint NOT NULL,
    label character varying(255) NOT NULL
);


ALTER TABLE roles OWNER TO travel_guide;

--
-- Name: routes; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE routes (
    id bigint NOT NULL,
    description character varying(255),
    image character varying(255),
    title character varying(255) NOT NULL
);


ALTER TABLE routes OWNER TO travel_guide;

--
-- Name: trips; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE trips (
    id bigint NOT NULL,
    amount_of_tourists integer,
    expiration_date timestamp without time zone,
    inssurance_sum double precision,
    max_amount_of_tourists integer,
    min_amount_of_tourists integer,
    price double precision NOT NULL,
    trip_end_date timestamp without time zone,
    trip_start_date timestamp without time zone,
    guide_id bigint,
    route_id bigint,
    insurance_sum double precision,
    CONSTRAINT trips_price_check CHECK ((price >= (0)::double precision))
);


ALTER TABLE trips OWNER TO travel_guide;

--
-- Name: users; Type: TABLE; Schema: public; Owner: travel_guide
--

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    role_id bigint
);


ALTER TABLE users OWNER TO travel_guide;

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: travel_guide
--

SELECT pg_catalog.setval('hibernate_sequence', 10, true);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY orders (id, pay_date, rejected, returned, payment_system_id, trip_id, user_id) FROM stdin;
\.


--
-- Data for Name: payment_systems; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY payment_systems (id, name) FROM stdin;
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY roles (id, label) FROM stdin;
2	USER
6	USER
10	USER
\.


--
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY routes (id, description, image, title) FROM stdin;
1	Some random stuff	assets/imgs/slider/nature1.jpg	Trip1
2	Some random stuff 2	assets/imgs/slider/nature2.jpg	Route2
3	Some random stuff 3	assets/imgs/slider/nature3.jpg	Route3
4	Some random stuff 4	assets/imgs/slider/nature4.jpg	Route4
5	Some random stuff 5	assets/imgs/slider/nature5.jpg	Route5
\.


--
-- Data for Name: trips; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY trips (id, amount_of_tourists, expiration_date, inssurance_sum, max_amount_of_tourists, min_amount_of_tourists, price, trip_end_date, trip_start_date, guide_id, route_id, insurance_sum) FROM stdin;
1	5	\N	\N	\N	10	200	\N	\N	\N	1	\N
2	5	\N	\N	\N	10	300	\N	\N	\N	2	\N
4	5	\N	\N	\N	10	4100	\N	\N	\N	4	\N
5	5	\N	\N	\N	10	4500	\N	\N	\N	5	\N
3	5	\N	\N	\N	10	100	\N	\N	\N	3	\N
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: travel_guide
--

COPY users (id, email, password, username, role_id) FROM stdin;
1	random@email.com	$2a$10$qS58SIsnHD5/PrvXwpdqcO21OiAVc6LhL.5uUHHHj/Sx7y7eNI842	username	2
5	user1@email.com	$2a$10$V2vOHmGn2ijm0D8oKPuKTOWqKvKKn2Ul/6SW4V0H5mjg0rEqzrwRu	username1	6
9	random1111@email.com	$2a$10$rzgPXBdXesQQY6.Iu9TxCurt6nQH.Ac5oBHbBqjJPQZIjp7v3m.JO	username1111	10
\.


--
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: payment_systems_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY payment_systems
    ADD CONSTRAINT payment_systems_pkey PRIMARY KEY (id);


--
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: routes_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (id);


--
-- Name: trips_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY trips
    ADD CONSTRAINT trips_pkey PRIMARY KEY (id);


--
-- Name: uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: uk_f98siu3wcreoyvve3yhetbcwo; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY payment_systems
    ADD CONSTRAINT uk_f98siu3wcreoyvve3yhetbcwo UNIQUE (name);


--
-- Name: uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: fk32ql8ubntj5uh44ph9659tiih; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES users(id);


--
-- Name: fkfo74kpvv8vf7lav8nnmhay2eg; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkfo74kpvv8vf7lav8nnmhay2eg FOREIGN KEY (payment_system_id) REFERENCES payment_systems(id);


--
-- Name: fkm7ci3blm9wj2k0d94chu18y7s; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY trips
    ADD CONSTRAINT fkm7ci3blm9wj2k0d94chu18y7s FOREIGN KEY (route_id) REFERENCES routes(id);


--
-- Name: fkp56c1712k691lhsyewcssf40f; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fkp56c1712k691lhsyewcssf40f FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- Name: fkpnggeu82c1likmyebim7se4ax; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY trips
    ADD CONSTRAINT fkpnggeu82c1likmyebim7se4ax FOREIGN KEY (guide_id) REFERENCES users(id);


--
-- Name: fksl66l3hmn2ucp1tw7l49wkuwb; Type: FK CONSTRAINT; Schema: public; Owner: travel_guide
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fksl66l3hmn2ucp1tw7l49wkuwb FOREIGN KEY (trip_id) REFERENCES trips(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

