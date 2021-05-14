drop table if exists Cards cascade;
drop table if exists Users cascade;


create table Cards(idCard INTEGER NOT NULL PRIMARY KEY, Name VARCHAR(30) NOT NULL, HP INTEGER NOT NULL, Attack INTEGER NOT NULL, Defense INTEGER NOT NULL, Description VARCHAR(500),imgUrl VARCHAR(500));
create table Users(idUser INTEGER NOT NULL PRIMARY KEY, Name VARCHAR(30) NOT NULL, Password VARCHAR(30) NOT NULL, Solde INTEGER);



insert into Cards values(1,'Superman', 100 ,50, 60,'Superman a été créé en Janvier 1933 par l’écrivain Jerry Siegel et l’artiste canadien Joe Shuster. Il fait partie des héros fictifs les plus connus. Fort et courageux, le héros est prêt à tout pour sauver les gens','https://lewebpedagogique.com/leblogdes5e/files/2016/12/Superman-233x300.jpg');
insert into Cards values(2,'Batman', 80 ,70, 70,'Batman est un personnage de fiction et super-héros de l univers DC Comics. Il a été créé en mai 1939 par le dessinateur Bob Kane et le scénariste Bill Finger. Il porte un uniforme représentant une chauve-souris.', 'https://upload.wikimedia.org/wikipedia/commons/1/1b/Batman_%28black_background%29.jpg');
insert into Cards values(3,'Deadpool', 120 ,80, 40,'Wade Wilson, alias Deadpool est un anti-héros évoluant dans l univers Marvel de la maison d édition Marvel Comics. Créé par le scénariste Fabian Nicieza et le dessinateur Rob Liefeld, le personnage de fiction apparaît pour la première fois dans le comic book The New Mutants #98 en février 1991.', 'https://images.squarespace-cdn.com/content/51b3dc8ee4b051b96ceb10de/1436795952833-4MLDY9P6JC3EYQNM6R42/image-asset.jpeg?content-type=image%2Fjpeg');
insert into Cards values(4,'Hulk', 150 ,100,80,'Le docteur Robert Bruce Banner (souvent nommé Bruce Banner, son deuxième prénom), alias Hulk, est un super-héros évoluant dans l univers Marvel de la maison d édition Marvel Comics. Créé par le scénariste Stan Lee et le dessinateur Jack Kirby, le personnage de fiction apparaît pour la première fois dans le comic book The Incredible Hulk (vol. 1) #1 en mai 1962.', 'http://www.marvel-world.com/contents/encyclopedie/biographies/h/hulk/hulk_0.jpg');
insert into Cards values(5,'Catwoman', 100 ,70, 40,'Héroïne féline et iconique, Catwoman est surtout célèbre pour sa relation tumultueuse avec Batman. Tout comme son animal fétiche, elle sait faire preuve de beaucoup d’agilité, à tel point qu’il est parfois difficile d’y voir clair dans son jeu.', 'https://img.fruugo.com/product/6/69/131338696_max.jpg');
insert into Cards values(6,'Captan America', 120 ,70, 80,'Un bouclier rond, un costume aux couleurs de l’Amérique et le corps d’un super-soldat dopé grâce au sérum S.S.S : Steve Rogers, alias Captain America, n’a qu’une obsession, celle à l’origine de sa création : combattre le nazisme. Pour honorer cette mission, ce personnage de comics est servi par des capacités physiques et intellectuelles hors-norme', 'http://www.marvel-world.com/contents/encyclopedie/biographies/c/captain-america-steve-rogers/captain-america-steve-rogers_0.jpg');
insert into Cards values(7,'Iron Man', 90 ,50, 80,'Iron Man est un super-héros de comics et de l univers Marvel . C est un homme de fer qui peut voler, lancer des rayons et qui a la force surpuissante.', 'http://www.marvel-world.com/contents/encyclopedie/biographies/i/iron-man/iron-man_0.jpg');
insert into Cards values(8,'Spiderman', 110 ,80, 70,'Peter Parker, alias Spider-Man (souvent écrit « Spiderman » de façon erronée) est un super-héros évoluant dans l univers Marvel de la maison d édition Marvel Comics. Créé par le scénariste Stan Lee et le dessinateur Steve Ditko, le personnage de fiction apparaît pour la première fois dans le comic book Amazing Fantasy (vol. 1) #15 en août 1962.', 'https://manuelmarvel.franceserv.com/Spider-Man_fichiers/image012.jpg');
insert into Cards values(9,'Thor', 150 ,100, 90,'Thor est une divinité et un super-héros appartenant à l’univers Marvel. Créé par l’éditeur Stan Lee, le scénariste Larry Lieber et le dessinateur Jack Kirby, le personnage de fiction apparait pour la première fois dans le comic book Journey into mistery #83 en aout 1962.', 'https://static.fnac-static.com/multimedia/Images/FD/Comete/28268/CCP_IMG_600x400/327514.jpg');
insert into Cards values(10,'Wonder Woman', 90 ,50, 70,'Wonder Woman est une super-héroïne de bande dessinée américaine créée par William Moulton Marston (sous le pseudonyme de Charles Moulton), qui apparaît pour la première fois en octobre 1941 dans All Star Comics #8. Elle est, à cette époque, l une des premières super-héroïnes et demeure la plus célèbre d entre elles.', 'https://www.telerama.fr/sites/tr_master/files/styles/simplecrop1000/public/medias/2016/10/media_148896/wonder-woman-icone-feministe-de-75-ans-devient-ambassadrice-de-l-onu%2CM382262.jpg?itok=kQe_EmGJ');


insert into Users values(1,'Thomas', 'Oui',500); 
insert into Users values(2,'Lucas', 'Non',500); 
insert into Users values(3,'Gabriel', 'Test',500); 
insert into Users values(4,'Gauthier', 'Bonjour',500); 
