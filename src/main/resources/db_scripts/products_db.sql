--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-06-04 14:05:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 224 (class 1259 OID 49161)
-- Name: product_categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_categories (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    line_id integer NOT NULL
);


ALTER TABLE public.product_categories OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 49160)
-- Name: product_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.product_categories_id_seq OWNER TO postgres;

--
-- TOC entry 4822 (class 0 OID 0)
-- Dependencies: 223
-- Name: product_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_categories_id_seq OWNED BY public.product_categories.id;


--
-- TOC entry 222 (class 1259 OID 49154)
-- Name: product_lines; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_lines (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.product_lines OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 49153)
-- Name: product_lines_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_lines_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.product_lines_id_seq OWNER TO postgres;

--
-- TOC entry 4823 (class 0 OID 0)
-- Dependencies: 221
-- Name: product_lines_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_lines_id_seq OWNED BY public.product_lines.id;


--
-- TOC entry 226 (class 1259 OID 49173)
-- Name: product_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_models (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    category_id integer NOT NULL
);


ALTER TABLE public.product_models OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 49172)
-- Name: product_models_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_models_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.product_models_id_seq OWNER TO postgres;

--
-- TOC entry 4824 (class 0 OID 0)
-- Dependencies: 225
-- Name: product_models_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_models_id_seq OWNED BY public.product_models.id;


--
-- TOC entry 4656 (class 2604 OID 49164)
-- Name: product_categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_categories ALTER COLUMN id SET DEFAULT nextval('public.product_categories_id_seq'::regclass);


--
-- TOC entry 4655 (class 2604 OID 49157)
-- Name: product_lines id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_lines ALTER COLUMN id SET DEFAULT nextval('public.product_lines_id_seq'::regclass);


--
-- TOC entry 4657 (class 2604 OID 49176)
-- Name: product_models id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_models ALTER COLUMN id SET DEFAULT nextval('public.product_models_id_seq'::regclass);


--
-- TOC entry 4814 (class 0 OID 49161)
-- Dependencies: 224
-- Data for Name: product_categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_categories (id, name, line_id) FROM stdin;
1	Cronos Old	1
2	Cronos L	1
3	Cronos NG	1
4	ARES TB	2
5	ARES THS	2
\.


--
-- TOC entry 4812 (class 0 OID 49154)
-- Dependencies: 222
-- Data for Name: product_lines; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_lines (id, name) FROM stdin;
1	Cronos
2	Ares
\.


--
-- TOC entry 4816 (class 0 OID 49173)
-- Dependencies: 226
-- Data for Name: product_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_models (id, name, category_id) FROM stdin;
1	Cronos 6001-A	1
2	Cronos 6003	1
3	Cronos 7023	1
4	Cronos 6021L	2
5	Cronos 6021L	2
6	Cronos 7023L	2
7	Cronos 6001-NG	3
8	Cronos 6003-NG	3
9	Cronos 6021-NG	3
10	Cronos 6031-NG	3
11	Cronos 7021-NG	3
12	Cronos 7023-NG	3
13	ARES 7021	4
14	ARES 7031	4
15	ARES 7023	4
16	ARES 8023 15	5
17	ARES 8023 200	5
18	ARES 8023 2,5	5
\.


--
-- TOC entry 4825 (class 0 OID 0)
-- Dependencies: 223
-- Name: product_categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_categories_id_seq', 11, true);


--
-- TOC entry 4826 (class 0 OID 0)
-- Dependencies: 221
-- Name: product_lines_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_lines_id_seq', 3, true);


--
-- TOC entry 4827 (class 0 OID 0)
-- Dependencies: 225
-- Name: product_models_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_models_id_seq', 30, true);


--
-- TOC entry 4661 (class 2606 OID 49166)
-- Name: product_categories product_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_categories
    ADD CONSTRAINT product_categories_pkey PRIMARY KEY (id);


--
-- TOC entry 4659 (class 2606 OID 49159)
-- Name: product_lines product_lines_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_lines
    ADD CONSTRAINT product_lines_pkey PRIMARY KEY (id);


--
-- TOC entry 4663 (class 2606 OID 49178)
-- Name: product_models product_models_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_models
    ADD CONSTRAINT product_models_pkey PRIMARY KEY (id);


--
-- TOC entry 4664 (class 2606 OID 49167)
-- Name: product_categories product_categories_line_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_categories
    ADD CONSTRAINT product_categories_line_id_fkey FOREIGN KEY (line_id) REFERENCES public.product_lines(id);


--
-- TOC entry 4665 (class 2606 OID 49179)
-- Name: product_models product_models_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_models
    ADD CONSTRAINT product_models_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.product_categories(id);


-- Completed on 2025-06-04 14:05:59

--
-- PostgreSQL database dump complete
--

