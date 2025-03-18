--
-- PostgreSQL database dump
--

-- Dumped from database version 14.17 (Ubuntu 14.17-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.17 (Ubuntu 14.17-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: tbl_author; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_author (id, email, full_name, image_url, joined_date, note, url_slug) FROM stdin;
ff10aabd-8290-4f4a-bfc7-32db181111e7	alice.johnson@email.com	Alice Johnson	\N	2025-03-14 11:18:32.802601	Experienced tech writer with a focus on AI.	alice-johnson
067f4373-05c1-4bc4-8b6a-9f686bf140c6	bob.williams@email.com	Bob Williams	\N	2025-03-14 11:18:44.853525	Travel enthusiast and photographer.	bob-williams
f7d75931-f765-4e91-8f9b-26356c0c641d	charlie.brown@email.com	Charlie Brown	\N	2025-03-14 11:18:52.552039	Food blogger specializing in vegan cuisine.	charlie-brown
0ae00ff4-e6af-49e3-a6ee-bf1c1038168b	david.garcia@email.com	David Garcia	\N	2025-03-14 11:19:01.920381	Lifestyle coach and wellness expert.	david-garcia
551ab6c2-c291-471d-a5ea-7c948a47eae0	emily.rodriguez@email.com	Emily Rodriguez	\N	2025-03-14 11:19:11.861739	Fashion blogger with a passion for sustainable fashion.	emily-rodriguez
68ef72d8-cb9a-41b4-8f60-b8b6c6500759	frank.wilson@email.com	Frank Wilson	\N	2025-03-14 11:19:21.142104	Financial advisor and personal finance blogger.	frank-wilson
e476cc87-4369-412c-a60c-b34b62e51780	grace.anderson@email.com	Grace Anderson	\N	2025-03-14 11:19:29.485802	Book reviewer and literary critic.	grace-anderson
7e18374f-9c89-4526-a8f1-88ec208394ea	henry.thomas@email.com	Henry Thomas	\N	2025-03-14 11:19:46.606843	Movie buff and film critic.	henry-thomas
81b7cf1a-bfbf-4c51-a752-bb4b78b166c9	isabella.jackson@email.com	Isabella Jackson	\N	2025-03-14 11:19:58.399567	Music journalist and concert photographer.	isabella-jackson
76735c1b-c695-4fd0-b5d3-2485439e4882	jack.white@email.com	Jack White	\N	2025-03-14 11:20:08.200831	Software developer and programming tutor.	jack-white
\.


--
-- Data for Name: tbl_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_category (id, description, name, show_on_menu, url_slug) FROM stdin;
2f12e11f-00d5-4539-b875-deb1b06e7ccf	Latest advancements and trends in technology.	Technology	f	technology
3873eeaa-f273-464c-851e-293b31dd58d1	Exploring new destinations and travel tips.	Travel	f	travel
7c20864a-abbe-4d25-a1f8-f53c9203bd70	Delicious recipes and culinary experiences.	Food	f	food
4b3f0553-fa18-4ad8-b172-04cfc69018f3	Tips for a balanced and fulfilling life.	Lifestyle	f	lifestyle
a3024438-5097-4e5c-b1eb-45511dd77085	Style trends and fashion advice.	Fashion	f	fashion
226f3e2a-01be-4160-9be6-20573427b004	Wellness and fitness information.	Health	f	health
71613be0-3944-44cd-84fb-e990fff65e2a	Personal finance and investment strategies.	Finance	f	finance
45266353-b324-4363-a3d1-8a047006b1ec	Book reviews and literary discussions.	Books	f	books
816b71e4-9987-4c35-bf28-bc7fc4f05eeb	Film reviews and entertainment news.	Movies	f	movies
24f4b048-3e2d-4975-9c05-da517a8e645d	Music reviews and artist interviews.	Music	f	music
1a41107f-e6aa-4a83-aca8-e83137db6332	Coding tips and software development tutorials.	Programming	f	programming
aa7eb807-25fb-4c84-a179-6268ccc599e4	Video game reviews and gaming news.	Gaming	f	gaming
d834955c-095f-45d0-927c-b22f8d87863d	Photography techniques and equipment reviews.	Photography	f	photography
39786bfe-ac15-4039-9b00-c46f335cea02	Interior design ideas and home improvement tips.	Home Decor	f	home-decor
7c16c51e-1d9d-4b62-a91d-1709a50ed5ac	Gardening tips and plant care advice.	Gardening	f	gardening
d59ef741-b2a1-4b97-9caa-99064cb07d9b	Business strategies and entrepreneurship insights.	Business	f	business
89d2d250-4f24-4692-ada8-bbbaf66323ec	Educational resources and learning tips.	Education	f	education
4ad41b9f-3ba7-4a0e-b5a9-cbb0d6a05d72	Scientific discoveries and research updates.	Science	f	science
68c5ca99-ed07-4faf-8889-c5b54718aeec	Sports news and athletic achievements.	Sports	f	sports
384860ed-eb24-40c1-93c8-444b7f52fc8c	Pet care tips and animal stories.	Pets	f	pets
\.


--
-- Data for Name: tbl_post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_post (id, description, image_url, meta, modified_date, posted_date, published, short_description, title, url_slug, view_count, author, category) FROM stdin;
e69612fa-ca05-440d-80b7-a4a2e1563066	A deep dive into the applications of AI in homes, workplaces, and beyond.	\N	AI, technology, future, innovation	2025-03-14 11:37:15.448712	2025-03-14 11:37:15.448739	f	Exploring how artificial intelligence is shaping our daily routines.	The Future of AI in Everyday Life	future-ai-everyday-life	0	ff10aabd-8290-4f4a-bfc7-32db181111e7	2f12e11f-00d5-4539-b875-deb1b06e7ccf
c2dee415-d4cd-4f46-a371-65824a81a4cd	A travel guide to unique and off-the-beaten-path locations in Kyoto.	\N	travel, Kyoto, Japan, adventure	2025-03-14 11:37:38.911159	2025-03-14 11:37:38.911184	f	Discovering the lesser-known attractions in Kyoto.	Exploring the Hidden Gems of Kyoto	hidden-gems-kyoto	0	067f4373-05c1-4bc4-8b6a-9f686bf140c6	3873eeaa-f273-464c-851e-293b31dd58d1
0da5b36a-bb34-4e42-b4e2-d87d59f2ab42	A guide to improving overall wellness through mindful practices.	\N	wellness, mindfulness, lifestyle, health	2025-03-14 11:38:21.539249	2025-03-14 11:38:21.539284	f	Tips for incorporating mindfulness into your daily life.	Achieving Wellness Through Mindful Living	wellness-mindful-living	0	0ae00ff4-e6af-49e3-a6ee-bf1c1038168b	4b3f0553-fa18-4ad8-b172-04cfc69018f3
8601408e-1479-492d-aed3-a36d0417d040	An overview of how to make more environmentally friendly fashion choices.	\N	fashion, sustainable, ethical, style	2025-03-14 11:38:36.869154	2025-03-14 11:38:36.86918	f	Exploring the importance of sustainable fashion and ethical brands.	Sustainable Fashion: A Guide to Ethical Choices	sustainable-fashion-guide	0	551ab6c2-c291-471d-a5ea-7c948a47eae0	a3024438-5097-4e5c-b1eb-45511dd77085
5031b1b9-0e10-4aa7-bd1d-274d4de395dd	A guide to effective budgeting and financial planning.	\N	finance, budgeting, personal finance, money	2025-03-14 11:38:54.647514	2025-03-14 11:38:54.647541	f	Practical tips for managing your finances and creating a budget.	Mastering Personal Finance: Budgeting Tips	mastering-personal-finance-budgeting	0	68ef72d8-cb9a-41b4-8f60-b8b6c6500759	71613be0-3944-44cd-84fb-e990fff65e2a
00eef64d-8d3f-4719-affb-d2f9fa90ddbd	Exploring the timeless appeal of classic literature.	\N	books, literature, reading, classics	2025-03-14 11:41:28.565639	2025-03-14 11:41:28.565666	f	A curated list of essential classic books for every reader.	Classic Literature: Must-Read Books	classic-literature-must-read	0	e476cc87-4369-412c-a60c-b34b62e51780	45266353-b324-4363-a3d1-8a047006b1ec
ad036f6f-a946-4fb2-876a-9d8a7d5913e4	Exploring the world of indie cinema and highlighting standout films.	\N	movies, film, indie, reviews	2025-03-14 11:41:50.456708	2025-03-14 11:41:50.456737	f	A review of the top independent films released this year.	The Best Indie Films of the Year	best-indie-films	0	7e18374f-9c89-4526-a8f1-88ec208394ea	816b71e4-9987-4c35-bf28-bc7fc4f05eeb
0ac32dd5-70f3-44d6-8e6e-fe0e14fa96a2	Breaking down the basics of music theory in an easy-to-understand way.	\N	music, theory, musicians, learning	2025-03-14 11:42:12.117841	2025-03-14 11:42:12.117861	f	A simple guide to music theory for aspiring musicians.	Understanding Music Theory for Beginners	understanding-music-theory	0	81b7cf1a-bfbf-4c51-a752-bb4b78b166c9	24f4b048-3e2d-4975-9c05-da517a8e645d
ae3ba90e-1667-4175-957b-cc48ce4bfaa1	A guide to efficient Python coding practices.	\N	programming, Python, coding, development	2025-03-14 11:42:33.193965	2025-03-14 11:42:33.193986	f	Practical tips and tricks for improving your Python programming skills.	Python Programming: Essential Tips	python-programming-tips	0	76735c1b-c695-4fd0-b5d3-2485439e4882	1a41107f-e6aa-4a83-aca8-e83137db6332
c9f54f88-47fb-44f7-9e9b-46181a32db87	Exploring the advancements in gaming from retro to modern.	\N	gaming, technology, video games, evolution	2025-03-14 11:42:51.055866	2025-03-14 11:42:51.055889	f	A look at how gaming technology has transformed over the years.	The Evolution of Gaming Technology	evolution-gaming-technology	0	ff10aabd-8290-4f4a-bfc7-32db181111e7	aa7eb807-25fb-4c84-a179-6268ccc599e4
9c722d87-5a01-427e-9c2d-7c755663c429	A look at AI tools for writing, design, and marketing.	\N	AI, content creation, technology, marketing	2025-03-14 11:51:02.75902	2025-03-14 11:51:02.759042	f	Exploring how AI is revolutionizing content creation processes.	AI-Powered Tools for Content Creation	ai-tools-content-creation	0	ff10aabd-8290-4f4a-bfc7-32db181111e7	2f12e11f-00d5-4539-b875-deb1b06e7ccf
e5295222-f7eb-40e4-a065-4ef4877010c8	A guide to exploring Nara's temples, deer park, and more.	\N	travel, Japan, Nara, Kyoto	2025-03-14 11:51:21.569919	2025-03-14 11:51:21.569942	f	Planning a day trip from Kyoto to Nara, Japan.	A Day Trip to Nara from Kyoto	day-trip-nara-from-kyoto	0	067f4373-05c1-4bc4-8b6a-9f686bf140c6	3873eeaa-f273-464c-851e-293b31dd58d1
266202d1-2f5f-4d9e-a15a-94cb80afe306	A collection of fast and healthy vegan breakfast meals.	\N	vegan, breakfast, food, healthy	2025-03-14 11:51:45.617701	2025-03-14 11:51:45.617725	f	Easy vegan breakfast recipes for a nutritious start to the day.	Quick and Healthy Vegan Breakfast Ideas	vegan-breakfast-ideas	0	f7d75931-f765-4e91-8f9b-26356c0c641d	7c20864a-abbe-4d25-a1f8-f53c9203bd70
1c4bad63-6b44-4b6b-a761-b7f18fb50704	Practical tips for managing stress in everyday situations.	\N	wellness, stress, lifestyle, health	2025-03-14 11:52:04.110805	2025-03-14 11:52:04.110825	f	Simple techniques to reduce stress and improve mental well-being.	Stress Reduction Techniques for Daily Life	stress-reduction-techniques	0	0ae00ff4-e6af-49e3-a6ee-bf1c1038168b	4b3f0553-fa18-4ad8-b172-04cfc69018f3
5fc9ae3d-38d2-47e9-9127-00b6cf56a183	A look at brands that prioritize ethical practices and environmental responsibility.	\N	fashion, ethical, sustainable, brands	2025-03-14 11:52:21.86253	2025-03-14 11:52:21.862564	f	Exploring the growing trend of ethical and sustainable fashion.	The Rise of Ethical Fashion Brands	rise-ethical-fashion-brands	0	551ab6c2-c291-471d-a5ea-7c948a47eae0	a3024438-5097-4e5c-b1eb-45511dd77085
04e0b241-8dc9-4e59-abdb-52126788644a	An introduction to basic investment principles and strategies.	\N	finance, investing, personal finance, money	2025-03-14 11:52:49.55462	2025-03-14 11:52:49.554638	f	A beginner's guide to investing and growing your wealth.	Investing Basics: Getting Started	investing-basics-getting-started	0	68ef72d8-cb9a-41b4-8f60-b8b6c6500759	71613be0-3944-44cd-84fb-e990fff65e2a
93837265-258c-4214-b9b8-c3d706399639	Exploring contemporary literature and highlighting noteworthy books.	\N	books, literature, reading, novels	2025-03-14 11:53:02.543861	2025-03-14 11:53:02.543887	f	A selection of compelling new novels that should be on your reading list.	Modern Literature: New Must-Read Novels	modern-literature-must-read	0	e476cc87-4369-412c-a60c-b34b62e51780	45266353-b324-4363-a3d1-8a047006b1ec
947c6eb7-02cb-42bb-a39a-9ee131c01a13	Exploring the challenges and rewards of indie filmmaking.	\N	movies, film, indie, filmmaking	2025-03-14 11:53:20.692093	2025-03-14 11:53:20.692119	f	An inside look at the process of creating independent films.	Behind the Scenes of Independent Filmmaking	behind-scenes-indie-filmmaking	0	7e18374f-9c89-4526-a8f1-88ec208394ea	816b71e4-9987-4c35-bf28-bc7fc4f05eeb
4204889b-65a2-4e7f-98e9-fddd69472d6e	An overview of different musical styles from around the world.	\N	music, genres, styles, culture	2025-03-14 11:53:49.984465	2025-03-14 11:53:49.984486	f	A guide to various music genres and their characteristics.	Exploring Different Music Genres	exploring-music-genres	0	81b7cf1a-bfbf-4c51-a752-bb4b78b166c9	24f4b048-3e2d-4975-9c05-da517a8e645d
b53fc844-16e9-4f18-8b7d-41e8c09ca1db	A guide to more complex and efficient Python programming.	\N	programming, Python, coding, development	2025-03-14 11:54:23.571378	2025-03-14 11:54:23.571408	f	Enhancing your Python skills with advanced programming methods.	Advanced Python Programming Techniques	advanced-python-programming	0	76735c1b-c695-4fd0-b5d3-2485439e4882	1a41107f-e6aa-4a83-aca8-e83137db6332
92c99870-6950-4596-834d-57e7ca1687db	A detailed analysis of AI applications in medicine, diagnostics, and patient care.	\N	AI, healthcare, technology, innovation	2025-03-14 11:56:37.161086	2025-03-14 11:56:37.161108	f	Examining the role of artificial intelligence in the healthcare industry.	AI in Healthcare: Innovations and Challenges	ai-healthcare-innovations	0	ff10aabd-8290-4f4a-bfc7-32db181111e7	2f12e11f-00d5-4539-b875-deb1b06e7ccf
a8713853-e53c-4a90-9806-f8c239bf0423	A guide to experiencing the less-visited regions of Japan.	\N	travel, Japan, rural, culture	2025-03-14 11:56:58.012942	2025-03-14 11:56:58.012964	f	Exploring the beauty and culture of rural Japan.	Off the Beaten Path: Rural Japan Travel	rural-japan-travel	0	067f4373-05c1-4bc4-8b6a-9f686bf140c6	3873eeaa-f273-464c-851e-293b31dd58d1
09e6c016-ab92-4117-b6bd-4438cc143cd1	A guide to preparing vegan meals in advance to save time and eat healthy.	\N	vegan, meal prep, food, healthy	2025-03-14 11:57:19.482325	2025-03-14 11:57:19.482355	f	Efficient vegan meal prep ideas for busy lifestyles.	Vegan Meal Prep for Busy Weeks	vegan-meal-prep	0	f7d75931-f765-4e91-8f9b-26356c0c641d	7c20864a-abbe-4d25-a1f8-f53c9203bd70
26776fb0-1e3a-4df1-b66a-82c165c42358	A guide to teaching mindfulness to kids, with practical exercises and tips.	\N	wellness, mindfulness, children, parenting	2025-03-14 11:57:40.669579	2025-03-14 11:57:40.669603	f	Introducing mindfulness practices to children for improved well-being.	Mindfulness for Children: Techniques and Benefits	mindfulness-for-children	0	0ae00ff4-e6af-49e3-a6ee-bf1c1038168b	4b3f0553-fa18-4ad8-b172-04cfc69018f3
3a96c842-c4c3-4ba4-aed5-8397ffdc2ed0	Examining the environmental and ethical impacts of the fashion industry.	\N	fashion, sustainable, ethical, industry	2025-03-14 11:57:59.13949	2025-03-14 11:57:59.139511	f	A comparison of fast fashion and sustainable fashion practices.	Fast Fashion vs. Sustainable Fashion	fast-fashion-vs-sustainable	0	551ab6c2-c291-471d-a5ea-7c948a47eae0	a3024438-5097-4e5c-b1eb-45511dd77085
2eaf78fb-5baf-4ab2-aaf8-d9c9b082210d	A comprehensive guide to retirement planning and investment strategies.	\N	finance, retirement, planning, money	2025-03-14 11:58:16.928152	2025-03-14 11:58:16.928178	f	Essential tips for planning a financially secure retirement.	Retirement Planning: Securing Your Future	retirement-planning	0	68ef72d8-cb9a-41b4-8f60-b8b6c6500759	71613be0-3944-44cd-84fb-e990fff65e2a
2f7bd9de-cad7-43c6-bc44-11ca05e5d787	Exploring the latest trends and authors in modern literature.	\N	books, literature, reading, contemporary	2025-03-14 11:58:47.464127	2025-03-14 11:58:47.464146	f	Highlighting new and diverse voices in contemporary literature.	Contemporary Literature: Emerging Voices	contemporary-literature	0	e476cc87-4369-412c-a60c-b34b62e51780	45266353-b324-4363-a3d1-8a047006b1ec
bb6d0d2c-1215-43a3-b019-1022eed2dcc3	An in-depth look at the process of creating impactful documentary films.	\N	movies, film, documentary, filmmaking	2025-03-14 11:59:07.061083	2025-03-14 11:59:07.06111	f	Exploring the techniques and challenges of documentary filmmaking.	The Art of Documentary Filmmaking	documentary-filmmaking	0	7e18374f-9c89-4526-a8f1-88ec208394ea	816b71e4-9987-4c35-bf28-bc7fc4f05eeb
9d170587-e2b8-4f99-8490-bb65c118aaab	Exploring the role of music in shaping cultural identities and traditions.	\N	music, culture, society, influence	2025-03-14 11:59:19.666837	2025-03-14 11:59:19.666857	f	Examining the impact of music on various cultures around the world.	The Influence of Music on Culture	influence-of-music-on-culture	0	81b7cf1a-bfbf-4c51-a752-bb4b78b166c9	24f4b048-3e2d-4975-9c05-da517a8e645d
fb6b7bcc-1a57-4c0c-9789-4fe0a72642f6	Exploring the tools and libraries used in data science with Python.	\N	programming, Python, data science, libraries	2025-03-14 11:59:38.251765	2025-03-14 11:59:38.251785	f	An overview of key Python libraries for data science applications.	Python for Data Science: Essential Libraries	python-for-data-science	0	76735c1b-c695-4fd0-b5d3-2485439e4882	1a41107f-e6aa-4a83-aca8-e83137db6332
\.


--
-- Data for Name: tbl_tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_tag (id, description, name, url_slug) FROM stdin;
7a0b9abe-be12-4a71-a2ac-470fa446d4a5	\N	Artificial Intelligence	artificial-intelligence
d4bbab25-ede1-4478-a5a1-ad5377a004ff	\N	Smart Homes	smart-homes
77baff54-52b9-4bd5-9f31-8a2973645e41	\N	Automation	automation
2925eff6-58cb-4166-9784-e3f0e5de8570	\N	Japan Travel	japan-travel
459386ba-833a-442c-80f2-54249ba2dea3	\N	Kyoto Guide	kyoto-guide
92bbe979-fcc6-49ba-aaa4-e73787080780	\N	Hidden Places	hidden-places
f32d1c51-5ebc-45c4-a009-0ac171ef06a5	\N	Vegan Food	vegan-food
f12c39a2-7884-48bf-a6f9-ed6f4a13cfe4	\N	Plant Based	plant-based
431eef25-c935-4174-8107-9585fa820729	\N	Easy Recipes	easy-recipes
4f04700b-05af-4d93-894c-247a6c0dd4c9	\N	Mindfulness	mindfulness
32d7f702-8d0e-4076-a5c6-7e9483be44d2	\N	Healthy Living	healthy-living
f8e00a28-1ded-4007-9c8f-57e7d2b99148	\N	Wellness Tips	wellness-tips
0b1f8789-3bbc-4287-9b3c-086fb0c134e6	\N	Sustainable Fashion	sustainable-fashion
81047241-8a2f-417d-a5b8-a5a089b37258	\N	Ethical Clothing	ethical-clothing
0493ecfe-1fa3-442e-bc49-c2a99aa33c82	\N	Eco Style	eco-style
df5e7161-653b-4206-8f9e-2ba289cb4f3f	\N	Personal Finance	personal-finance
8d4c1663-a0bd-4303-a532-b4aea12bca57	\N	Budgeting	budgeting
f3ac70a3-f319-4f54-82b2-532beda1270a	\N	Money Management	money-management
a088715c-3f47-490f-8f42-2279541a9790	\N	Classic Books	classic-books
2cf91863-0e7f-43f7-b80e-38248d27b2e4	\N	Literature	literature
e2d72d05-8544-49d7-bc2d-cf9bc953721d	\N	Reading List	reading-list
81dca013-9f5f-420c-a8e1-fe097bfebba9	\N	Indie Films	indie-films
fd2f88d6-0930-4238-84d0-fdbefcb6090a	\N	Movie Reviews	movie-reviews
2dd83572-1a60-4d34-9739-0e2176f11817	\N	Cinema	cinema
34014454-8ad3-4cbe-a80b-4650a642a32f	\N	Music Theory	music-theory
412f27f5-ec58-4ba9-bcd8-41bca5c6fa93	\N	Musicians	musicians
5e000744-08e5-4207-8525-28cb0bb43411	\N	Music Lessons	music-lessons
4268e96f-863d-4e5a-8dba-90dfaa4ff0a4	\N	Python Programming	python-programming
b22c5c32-8864-445c-aefe-271bb656e424	\N	Coding Tips	coding-tips
6986c75d-76ef-4a08-be21-e0e581d202be	\N	Software Development	software-development
0f0e1a05-7eb7-4f90-bebf-d2952c6a9e43	\N	Gaming Technology	gaming-technology
f67c8540-46ff-4db3-8b56-e91933455098	\N	Video Games	video-games
e345eb13-4ff1-4ceb-93db-631929920fc3	\N	Gaming History	gaming-history
d06aa1df-e1ab-4d59-bb68-75e77f8dcecf	\N	Marketing	marketing
2069f562-5e57-4566-8064-e4a847993bc7	\N	Nara	nara
48e75aec-442c-4f20-92ee-993ea8ab61b2	\N	DayTrip	daytrip
4526639b-df4d-48cc-843f-b2e84afa2d77	\N	Healthy Eating	healthy-eating
8b87a9af-1bb5-4df1-b075-253b3d88674a	\N	Stress Management	stress-management
22c96def-69a1-42c2-8e8f-dd02f5eeb6d1	\N	Investing	investing
fc481c6d-5a6c-4507-9dda-b7f2d6895327	\N	New Releases	new-releases
a7fdde2a-57fe-4198-a7e8-04399fa9ce4a	\N	Filmmaking	filmmaking
d58fcf98-b767-43fc-8f96-a6321e3e3d41	\N	Music	music
789e725f-0bbe-432c-a467-7e831c247fbb	\N	Music Culture	music-culture
69ef7251-19e4-4cca-a92d-793ca4d48f52	\N	Music History	music-history
149b60b5-49b9-4801-a3fb-3b310f66f912	\N	Advanced Coding	advanced-coding
ae6ae0b5-f914-49a2-8df4-dba0ef710821	\N	Healthcare	healthcare
f2aaf5f6-849b-4307-abd7-b8a73fc197eb	\N	Medical Technology	medical-technology
823da756-2522-41c7-90bc-3b83da36cc20	\N	Rural Japan	rural-japan
cb25bffd-14ed-4ca9-a0e7-d92cea993da0	\N	Cultural Travel	cultural-travel
2cd861ee-eee0-425f-9be6-420932be520e	\N	Meal Planning	meal-planning
db7701f8-7b96-44ad-a1a6-764a2566eddf	\N	Parenting	parenting
309c73e2-b186-4c28-8fb8-229c67c3da9d	\N	Child Development	child-development
f1e4b8f7-d104-43c5-a53b-e471716445a2	\N	Fashion Industry	fashion-industry
5789c1c4-96bc-4ad7-8825-f6aeb8a5c532	\N	Retirement	retirement
8417b889-ee4b-459d-9933-e3c599d6d3b0	\N	Emerging Authors	emerging-authors
233b789c-fb71-4929-983f-ca4408b46f74	\N	Documentary	documentary
067109c9-0641-4996-a8bf-5c2e250ede09	\N	Society	society
25c2827d-d21d-4eae-bee6-0f218445bea1	\N	Data Science	data-science
f38a76d7-3e32-4ccc-a677-d7f5c0da063c	\N	Programming Libraries	programming-libraries
\.


--
-- Data for Name: tbl_post_tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_post_tag (post, tag) FROM stdin;
e69612fa-ca05-440d-80b7-a4a2e1563066	7a0b9abe-be12-4a71-a2ac-470fa446d4a5
e69612fa-ca05-440d-80b7-a4a2e1563066	d4bbab25-ede1-4478-a5a1-ad5377a004ff
e69612fa-ca05-440d-80b7-a4a2e1563066	77baff54-52b9-4bd5-9f31-8a2973645e41
c2dee415-d4cd-4f46-a371-65824a81a4cd	92bbe979-fcc6-49ba-aaa4-e73787080780
c2dee415-d4cd-4f46-a371-65824a81a4cd	2925eff6-58cb-4166-9784-e3f0e5de8570
c2dee415-d4cd-4f46-a371-65824a81a4cd	459386ba-833a-442c-80f2-54249ba2dea3
0da5b36a-bb34-4e42-b4e2-d87d59f2ab42	f8e00a28-1ded-4007-9c8f-57e7d2b99148
0da5b36a-bb34-4e42-b4e2-d87d59f2ab42	4f04700b-05af-4d93-894c-247a6c0dd4c9
0da5b36a-bb34-4e42-b4e2-d87d59f2ab42	32d7f702-8d0e-4076-a5c6-7e9483be44d2
8601408e-1479-492d-aed3-a36d0417d040	0b1f8789-3bbc-4287-9b3c-086fb0c134e6
8601408e-1479-492d-aed3-a36d0417d040	81047241-8a2f-417d-a5b8-a5a089b37258
8601408e-1479-492d-aed3-a36d0417d040	0493ecfe-1fa3-442e-bc49-c2a99aa33c82
5031b1b9-0e10-4aa7-bd1d-274d4de395dd	8d4c1663-a0bd-4303-a532-b4aea12bca57
5031b1b9-0e10-4aa7-bd1d-274d4de395dd	df5e7161-653b-4206-8f9e-2ba289cb4f3f
5031b1b9-0e10-4aa7-bd1d-274d4de395dd	f3ac70a3-f319-4f54-82b2-532beda1270a
00eef64d-8d3f-4719-affb-d2f9fa90ddbd	a088715c-3f47-490f-8f42-2279541a9790
00eef64d-8d3f-4719-affb-d2f9fa90ddbd	2cf91863-0e7f-43f7-b80e-38248d27b2e4
00eef64d-8d3f-4719-affb-d2f9fa90ddbd	e2d72d05-8544-49d7-bc2d-cf9bc953721d
ad036f6f-a946-4fb2-876a-9d8a7d5913e4	81dca013-9f5f-420c-a8e1-fe097bfebba9
ad036f6f-a946-4fb2-876a-9d8a7d5913e4	2dd83572-1a60-4d34-9739-0e2176f11817
ad036f6f-a946-4fb2-876a-9d8a7d5913e4	fd2f88d6-0930-4238-84d0-fdbefcb6090a
0ac32dd5-70f3-44d6-8e6e-fe0e14fa96a2	412f27f5-ec58-4ba9-bcd8-41bca5c6fa93
0ac32dd5-70f3-44d6-8e6e-fe0e14fa96a2	5e000744-08e5-4207-8525-28cb0bb43411
0ac32dd5-70f3-44d6-8e6e-fe0e14fa96a2	34014454-8ad3-4cbe-a80b-4650a642a32f
ae3ba90e-1667-4175-957b-cc48ce4bfaa1	6986c75d-76ef-4a08-be21-e0e581d202be
ae3ba90e-1667-4175-957b-cc48ce4bfaa1	b22c5c32-8864-445c-aefe-271bb656e424
ae3ba90e-1667-4175-957b-cc48ce4bfaa1	4268e96f-863d-4e5a-8dba-90dfaa4ff0a4
c9f54f88-47fb-44f7-9e9b-46181a32db87	e345eb13-4ff1-4ceb-93db-631929920fc3
c9f54f88-47fb-44f7-9e9b-46181a32db87	0f0e1a05-7eb7-4f90-bebf-d2952c6a9e43
c9f54f88-47fb-44f7-9e9b-46181a32db87	f67c8540-46ff-4db3-8b56-e91933455098
9c722d87-5a01-427e-9c2d-7c755663c429	7a0b9abe-be12-4a71-a2ac-470fa446d4a5
9c722d87-5a01-427e-9c2d-7c755663c429	77baff54-52b9-4bd5-9f31-8a2973645e41
9c722d87-5a01-427e-9c2d-7c755663c429	d06aa1df-e1ab-4d59-bb68-75e77f8dcecf
e5295222-f7eb-40e4-a065-4ef4877010c8	459386ba-833a-442c-80f2-54249ba2dea3
e5295222-f7eb-40e4-a065-4ef4877010c8	48e75aec-442c-4f20-92ee-993ea8ab61b2
e5295222-f7eb-40e4-a065-4ef4877010c8	2925eff6-58cb-4166-9784-e3f0e5de8570
e5295222-f7eb-40e4-a065-4ef4877010c8	2069f562-5e57-4566-8064-e4a847993bc7
266202d1-2f5f-4d9e-a15a-94cb80afe306	f32d1c51-5ebc-45c4-a009-0ac171ef06a5
266202d1-2f5f-4d9e-a15a-94cb80afe306	f12c39a2-7884-48bf-a6f9-ed6f4a13cfe4
266202d1-2f5f-4d9e-a15a-94cb80afe306	4526639b-df4d-48cc-843f-b2e84afa2d77
1c4bad63-6b44-4b6b-a761-b7f18fb50704	32d7f702-8d0e-4076-a5c6-7e9483be44d2
1c4bad63-6b44-4b6b-a761-b7f18fb50704	8b87a9af-1bb5-4df1-b075-253b3d88674a
1c4bad63-6b44-4b6b-a761-b7f18fb50704	4f04700b-05af-4d93-894c-247a6c0dd4c9
5fc9ae3d-38d2-47e9-9127-00b6cf56a183	0493ecfe-1fa3-442e-bc49-c2a99aa33c82
5fc9ae3d-38d2-47e9-9127-00b6cf56a183	0b1f8789-3bbc-4287-9b3c-086fb0c134e6
5fc9ae3d-38d2-47e9-9127-00b6cf56a183	81047241-8a2f-417d-a5b8-a5a089b37258
04e0b241-8dc9-4e59-abdb-52126788644a	df5e7161-653b-4206-8f9e-2ba289cb4f3f
04e0b241-8dc9-4e59-abdb-52126788644a	f3ac70a3-f319-4f54-82b2-532beda1270a
04e0b241-8dc9-4e59-abdb-52126788644a	22c96def-69a1-42c2-8e8f-dd02f5eeb6d1
93837265-258c-4214-b9b8-c3d706399639	fc481c6d-5a6c-4507-9dda-b7f2d6895327
93837265-258c-4214-b9b8-c3d706399639	2cf91863-0e7f-43f7-b80e-38248d27b2e4
93837265-258c-4214-b9b8-c3d706399639	e2d72d05-8544-49d7-bc2d-cf9bc953721d
947c6eb7-02cb-42bb-a39a-9ee131c01a13	a7fdde2a-57fe-4198-a7e8-04399fa9ce4a
947c6eb7-02cb-42bb-a39a-9ee131c01a13	81dca013-9f5f-420c-a8e1-fe097bfebba9
947c6eb7-02cb-42bb-a39a-9ee131c01a13	2dd83572-1a60-4d34-9739-0e2176f11817
4204889b-65a2-4e7f-98e9-fddd69472d6e	d58fcf98-b767-43fc-8f96-a6321e3e3d41
4204889b-65a2-4e7f-98e9-fddd69472d6e	789e725f-0bbe-432c-a467-7e831c247fbb
4204889b-65a2-4e7f-98e9-fddd69472d6e	69ef7251-19e4-4cca-a92d-793ca4d48f52
b53fc844-16e9-4f18-8b7d-41e8c09ca1db	6986c75d-76ef-4a08-be21-e0e581d202be
b53fc844-16e9-4f18-8b7d-41e8c09ca1db	4268e96f-863d-4e5a-8dba-90dfaa4ff0a4
b53fc844-16e9-4f18-8b7d-41e8c09ca1db	149b60b5-49b9-4801-a3fb-3b310f66f912
92c99870-6950-4596-834d-57e7ca1687db	7a0b9abe-be12-4a71-a2ac-470fa446d4a5
92c99870-6950-4596-834d-57e7ca1687db	f2aaf5f6-849b-4307-abd7-b8a73fc197eb
92c99870-6950-4596-834d-57e7ca1687db	ae6ae0b5-f914-49a2-8df4-dba0ef710821
a8713853-e53c-4a90-9806-f8c239bf0423	2925eff6-58cb-4166-9784-e3f0e5de8570
a8713853-e53c-4a90-9806-f8c239bf0423	823da756-2522-41c7-90bc-3b83da36cc20
a8713853-e53c-4a90-9806-f8c239bf0423	cb25bffd-14ed-4ca9-a0e7-d92cea993da0
09e6c016-ab92-4117-b6bd-4438cc143cd1	4526639b-df4d-48cc-843f-b2e84afa2d77
09e6c016-ab92-4117-b6bd-4438cc143cd1	2cd861ee-eee0-425f-9be6-420932be520e
09e6c016-ab92-4117-b6bd-4438cc143cd1	f32d1c51-5ebc-45c4-a009-0ac171ef06a5
26776fb0-1e3a-4df1-b66a-82c165c42358	db7701f8-7b96-44ad-a1a6-764a2566eddf
26776fb0-1e3a-4df1-b66a-82c165c42358	309c73e2-b186-4c28-8fb8-229c67c3da9d
26776fb0-1e3a-4df1-b66a-82c165c42358	4f04700b-05af-4d93-894c-247a6c0dd4c9
3a96c842-c4c3-4ba4-aed5-8397ffdc2ed0	f1e4b8f7-d104-43c5-a53b-e471716445a2
3a96c842-c4c3-4ba4-aed5-8397ffdc2ed0	0493ecfe-1fa3-442e-bc49-c2a99aa33c82
3a96c842-c4c3-4ba4-aed5-8397ffdc2ed0	0b1f8789-3bbc-4287-9b3c-086fb0c134e6
2eaf78fb-5baf-4ab2-aaf8-d9c9b082210d	df5e7161-653b-4206-8f9e-2ba289cb4f3f
2eaf78fb-5baf-4ab2-aaf8-d9c9b082210d	5789c1c4-96bc-4ad7-8825-f6aeb8a5c532
2eaf78fb-5baf-4ab2-aaf8-d9c9b082210d	22c96def-69a1-42c2-8e8f-dd02f5eeb6d1
2f7bd9de-cad7-43c6-bc44-11ca05e5d787	8417b889-ee4b-459d-9933-e3c599d6d3b0
2f7bd9de-cad7-43c6-bc44-11ca05e5d787	2cf91863-0e7f-43f7-b80e-38248d27b2e4
2f7bd9de-cad7-43c6-bc44-11ca05e5d787	e2d72d05-8544-49d7-bc2d-cf9bc953721d
bb6d0d2c-1215-43a3-b019-1022eed2dcc3	233b789c-fb71-4929-983f-ca4408b46f74
bb6d0d2c-1215-43a3-b019-1022eed2dcc3	2dd83572-1a60-4d34-9739-0e2176f11817
bb6d0d2c-1215-43a3-b019-1022eed2dcc3	a7fdde2a-57fe-4198-a7e8-04399fa9ce4a
9d170587-e2b8-4f99-8490-bb65c118aaab	789e725f-0bbe-432c-a467-7e831c247fbb
9d170587-e2b8-4f99-8490-bb65c118aaab	067109c9-0641-4996-a8bf-5c2e250ede09
9d170587-e2b8-4f99-8490-bb65c118aaab	d58fcf98-b767-43fc-8f96-a6321e3e3d41
fb6b7bcc-1a57-4c0c-9789-4fe0a72642f6	f38a76d7-3e32-4ccc-a677-d7f5c0da063c
fb6b7bcc-1a57-4c0c-9789-4fe0a72642f6	4268e96f-863d-4e5a-8dba-90dfaa4ff0a4
fb6b7bcc-1a57-4c0c-9789-4fe0a72642f6	25c2827d-d21d-4eae-bee6-0f218445bea1
\.


--
-- PostgreSQL database dump complete
--

