# Java Pacman  

 `Echipa: Zamfir Adrian-Iulian (solo)`  
 `Grupa 2A5`  
 
# Descrierea proiectului   

 Am incercat sa recreez clasicul joc "PacMan" (1980) in paradigma limbajului Java. 
 Jocul urmeaza modelul de "ENDLESS", adica nu se va termina niciodata, atata timp cat 
 mai sunt vieti ramase. Scopul este sa "mananci" bilute, sa te feresti de inamicii 
 care iti apar in fata ("the ghosts") si sa scoti un scor cat mai mare. De fiecare data 
 ce bordul jocului sa goleste in totalitate, dificulatea este sporita prin a schimba
viteza inamicilor si prin a adauga un inamic complet nou.
 

# Subiecte atinse   

--- Programare bazata pe obiecte ( parsarea de obiecte intre mai multe clase, initializarea 
de variabile si utilizarea unor functii pentru a randa grafica jocului si pentru a tine
minte starea sa )  
--- Streamuri de input si output ( playerul de sunete cat si citirea mapii din fisier )  
--- Exceptii ( Exceptiile apar doar la citirea din fisier a mapei jocului )  
--- GUI ( bazat pe java swing, desenare frame by frame a jocului si actiunilor jucatorului )  
--- Folosirea unui thread concurent ( un "TIMER" care intervine la fiecare secunda si 
incetineste randarea starii curente a jocului, pentru a putea da suficient timp algoritmului
sa nu produca erori in calcul )

# Update log  

30.04.2021 --> v0.1 inceperea proiectului prin crearea GUI-ului si integrarea unui Adaptor
pentru taste  
03.05.2021 --> v0.3 Hardcodarea mapii direct intr-o variabila a jocului, inceputul algoritmului
pentru AI-ul botilor, inceputul algoritmului pentru miscarea jucatorului.  
Modul in care m-am gandit sa hardcodez mapa ( see below )

LEGENDA MAPII:   
0 = un block gol ( se va umple cu un patratel albastru )  
1 = marginea din stanga a unui block  
2 = marginea superioara a unui block  
4 = marginea din dreapta a unui block  
8 = marginea inferioara a unui block  
16 = bilutele/mancarea lui pacman ( un cer mic si alb )  

Astfel ca o valoare din vectorul in care este salvat mapa va fi calculat prin adunarea
unora de mai sus, de exemplu, ma aflu intr-un block care are o margina superioara, una inferioara
si o bulinuta de macare, deci valoarea va fi 2 + 8 + 16 = 26, etc...  

03.05.2021 --> v0.4 Algoritmul AI functional ( cu mici buguri, fantomele uneori trec prin 
zid )  
05.05.2021 --> v0.6 Integrarea algorimului pentru controlul jucatorului, rezolvarea bugului
care permitea trecerea prin pereti a fantomelor
-----
08.05.2021 --> v0.8 Am adaugat un player de muzica/sunete, de fiecare data cand jucatorul mananca
o biluta, un sunet specific este jucat, tot asa si pentru cand playerul se loveste de o fantoma.
Am adaugat si o muzica de ambient care merge in loop continuu pana la resetarea mapii.  
08.05.2021 --> forgot to push the above changes ( dumb me )  
08.05.2021 --> v1.0 Am separat variabilele jocului si le-am pus intr-o clasa specifica
( ca sa fie mai usor de citit codul ). Am adaugat un mic "TIMER" thread pentru a incetini
randarea jocului ( uneori algoritmul ramanea in urma si randarea devenea eronata ). Trebuie
un pic mai mult lucrat la prelucrarea datelor, such as, folosirea unor colectii in loc de 
C-style vectors !-!-WIP-!-!.
----
14.05.2021 --> v1.1 Am renuntat la ideea de folosirea a colectiilor in favorul vectorilor in stil C
( pentru anumite motive nu puteam stoca mai mult de 100 variabile, iar eu lucrez cu o mapa
de marime 15X15 = 225 ). Mic update la initializarea mapii jocului, acum o citesc dintr-un 
fisier, am scost cateva variabile care nu-si mai aveau rostul in cod, variabile care erau
just for testing. Am updatat initializarea imaginilor, muzicii, utilizand directorul de lucru curent, 
nu prin a hardcoda locatia acestora. Am renuntat la incercarea de a adauga bonusuri care sa 
permita jucatorului sa manance si fantomele ( algoritmul pe care l-am facut este deja prea
complicat iar adaugarea unei noi variabile incetinea prea mult rularea jocului si ReHardcodarea mapii 
)
