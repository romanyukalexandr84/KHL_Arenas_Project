INSERT INTO cities (name) VALUES
('Ярославль'),
('Магнитогорск'),
('Челябинск'),
('Екатеринбург'),
('Омск'),
('Москва'),
('Санкт-Петербург'),
('Череповец'),
('Казань'),
('Хабаровск'),
('Нижнекамск'),
('Владивосток'),
('Астана'),
('Уфа'),
('Новосибирск'),
('Балашиха'),
('Сочи'),
('Нижний Новгород'),
('Минск'),
('Мытищи'),
('Тольятти') ON CONFLICT DO NOTHING
;

INSERT INTO clubs (name) VALUES
('Локомотив'),
('Металлург'),
('Трактор'),
('Автомобилист'),
('Авангард'),
('Динамо М'),
('СКА'),
('Спартак'),
('Северсталь'),
('ЦСКА'),
('Ак Барс'),
('Амур'),
('Нефтехимик'),
('Адмирал'),
('Барыс'),
('Салават Юлаев'),
('Сибирь'),
('Витязь'),
('Сочи'),
('Торпедо'),
('Динамо Мн'),
('Куньлунь Ред Стар'),
('Лада') ON CONFLICT DO NOTHING
;

INSERT INTO activities (name) VALUES
('Каток, Ресторан, Аренда льда'),
('Ресторан, Аренда льда'),
('Аренда льда, Выставочный холл, Конференц-зал, Спортзал, Танцевальный зал'),
('Аренда льда, Аренда офисов'),
('Аренда льда, Конференц-зал'),
('Аренда льда, Конференц-зал, Ресторан, Экскурсии, Фотосессии'),
('Аренда льда, Фитнес-центр, Ресторан, Экскурсии'),
('Аренда льда, Спортивные секции'),
('Аренда льда, Спортивные секции, Ресторан, Танцпол'),
('Аренда льда, Конференц-зал, Ресторан'),
('Аренда льда, Ресторан'),
('Каток, Аренда льда, Экскурсии'),
('Каток, Аренда льда'),
('Аренда льда, Каток'),
('Аренда льда, Бассейн, Ресторан'),
('Аренда льда, Ресторан, Каток'),
('Каток, Аренда льда, Спортзал'),
('Каток, Аренда льда, Спортивные секции'),
('Аренда льда, Конференц-зал, Ресторан, Экскурсии'),
('Аренда льда, Конференц-зал, Ресторан, Библиотека'),
('Каток, Аренда льда, Конференц-зал, Спортзал, Ресторан, Экскурсии, Велодром'),
('Каток, Аренда льда, Конференц-зал, Спортивные секции'),
('Каток, Аренда льда, Фотосессии') ON CONFLICT DO NOTHING
;

INSERT INTO arenas (name , club_id, city_id, capacity , entry_year , tickets_url,
    attendance, prices, activities_id) VALUES
('Арена 2000', 1, 1, 8905, 2001, 'https://tickets.hclokomotiv.ru', 6623, '250-1000', 1),
('Арена Металлург', 2, 2, 7500, 2007, 'https://tickets.metallurg.ru', 6615, '400-1100', 2),
('Ледовая арена «Трактор»', 3, 3, 7500, 2009, 'https://my.hctraktor.org/tickets', 7347, '350-1200', 3),
('Арена Уралец', 4, 4, 5500, 1970, 'https://tickets.hc-avto.ru', 5167, '500-2100', 4),
('G-Drive Арена', 5, 5, 12000, 2022, 'https://tickets.hawk.ru/tickets', 11702, '150-5000', 5),
('ВТБ Арена', 6, 6, 12273, 2018, 'https://tickets.dynamo.ru', 6968, '300-5000', 6),
('СКА Арена', 7, 7, 21542, 2023, 'https://tickets.ska.ru', 20282, '430-3000', 7),
('Дворец спорта «Мегаспорт»', 8, 6, 11748, 2006, 'https://tickets.spartak.ru/tickets', 6498, '390-900', 8),
('Ледовый дворец', 9, 8, 5685, 2006, 'https://arena-che.ru/tickets', 4495, '350-800', 9),
('ЦСКА Арена', 10, 6, 12300, 2015, 'https://cska-hockey.ru/tickets/ticket-program', 6531, '300-2500', 10),
('Татнефть Арена', 11, 9, 8900, 2005, 'https://www.ak-bars.ru/tickets', 7028, '350-2350', 11),
('Платинум Арена', 12, 10, 7100, 2003, 'https://tickets.hcamur.ru', 6575, '350-2500', 12),
('Нефтехим Арена', 13, 11, 5500, 2005, 'https://tickets.hcnh.ru', 3217, '400-700', 13),
('Фетисов Арена', 14, 12, 5915, 2013, 'http://tickets.hcadmiral.ru', 4411, '575-2350', 14),
('Барыс Арена', 15, 13, 12000, 2015, 'https://ru.hcbarys.kz/tickets', 5877, '250-1200', 15),
('Уфа-Арена', 16, 14, 8522, 2007, 'https://tickets.hcsalavat.ru/ru', 7620, '400-1700', 16),
('Сибирь-Арена', 17, 15, 10587, 2023, 'https://tickets.hcsibir.ru', 10224, '390-3000', 17),
('Арена Балашиха', 18, 16, 5525, 2007, 'https://tickets.hcvityaz', 2872, '250-900', 18),
('Ледовый дворец «Большой»', 19, 17, 12000, 2013, 'https://tickets.hcsochi.ru', 4659, '300-3950', 19),
('Спорткомплекс «Нагорный»', 20, 18, 5600, 2007, 'https://hctorpedo.ru/tickets', 5500, '700-2100', 20),
('Минск-Арена', 21, 19, 15000, 2010, 'https://hcdinamo.by/tickets', 12057, '300-2100', 21),
('Арена Мытищи', 22, 20, 7114, 2005, 'https://msk.kassir.ru/sport/hk-kunlun-red-star', 1057, '250-800', 22),
('Лада-Арена', 23, 21, 6200, 2013, 'https://tickets.tlt-arena.ru', 5315, '500-1200', 23) ON CONFLICT DO NOTHING
;
