# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Wyświetlenie danych osoby wygrywającej aukcję

[Kupujący](#ac2)
* [AC1](#ac1): Wyszukanie produktu z listy oferowanych produktów
* [AC2](#ac2): Sprawdzenie aktualnej kwoty aukcyjnej
* [AC3](#ac3): Deklaracja kwoty przeznaczanej na licytacje danego produktu
* [AC4](#ac4): Przekazanie należności sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc1"></a>
### UC2: Licytacja produktu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wyszukuje interesujący go produkt z listy aktualnie wystawionych produktów.
2. [Kupujący](#ac2) sprawdza aktualną cenę produktu.
3. System wyświetla cenę produktu.
4. [Kupujący](#ac2) wypełnia dokument chęci udziału w licytacji konkretnego produktu.
5. System weryfikuje poprawność danych.
6. [Kupujący](#ac2) Deklaruje kwotę jaką chcę przeznaczyć na licytację konkretnego produktu.
7. System sprawdza czy zaoferowana kwota jest wyższa od aktualnej.

**Scenariusze alternatywne:** 

5.A. Wykryto nieprawidłowe dane
* 5.A.1. System informuje o wprowadzeniu nieprawidłowych danych
* 5.A.2. Przejdź do kroku 4.

7.A Zadeklarowana kwota jest niższa bądź równa od aktualnej
* 7.A.1. System informuje o zbyt niskiej kwocie.
* 7.A.2. Przejdź do kroku 6.

---

<a id="uc2"></a>
### UC2: Przekazanie należności sprzedającemu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuje użytkownika gdy jego kwota została przelicytowana.
2. System informuje użytkownika po zakończeniu licytacji o jego ew. wygranej


**Scenariusze alternatywne:** 

2.A. Przegrano licytację
* 2.A.1. System informuje o przegraniu licytacji.

---

<a id="uc2"></a>
### UC2: Przekazanie należności sprzedającemu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wypełnia deklarację przekaznia środków pieniężnych z konta.
2. [Kupujący](#ac2) wypełnia dane dotyczące wysyłki produktu.
3. System weryfikuje poprawność danych

**Scenariusze alternatywne:** 

3.A. Wykryto niepoprawne dane
* 3.A.1. System informuje o wprowadzeniu nieprawidłowych danych.
* 3.A.2. Przejdź do kroku 2.


---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


