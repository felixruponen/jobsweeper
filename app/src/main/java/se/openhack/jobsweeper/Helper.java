package se.openhack.jobsweeper;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class Helper {

    public static String getMockUser(){
        return "{\n" +
                "    \"id\": 2,\n" +
                "    \"image\": \"https://i.ytimg.com/vi/7p13vPNTQkQ/hqdefault.jpg\",\n" +
                "    \"name\": \"Felex P\",\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"counter\": 2,\n" +
                "            \"name\": \"Web\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"counter\": 2,\n" +
                "            \"name\": \"Java\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"counter\": 0,\n" +
                "            \"name\": \"SQL\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public static String getMockResponse(){
       return "[\n" +
                "  {\n" +
                "    \"platsannons\": {\n" +
                "      \"annons\": {\n" +
                "        \"annonsid\": \"6965402\",\n" +
                "        \"platsannonsUrl\": \"http://www.arbetsformedlingen.se/ledigajobb?id=6965402\",\n" +
                "        \"annonsrubrik\": \"Nätverkande IT-rekryterare till Zacco\",\n" +
                "        \"annonstext\": \"IT-rekryterare\\r\\nZacco is a modern, consultancy driven company with a 360° perspective on Intellectual Property: From patent filing, trademark registration and design protection to dispute resolution, information security and portfolio management. We are more than 300 experts within all aspects of Intellectual Property including a large number of experienced Patent, Trademark and Design Attorneys as well as highly skilled Attorneys at Laws, Paralegals and IT Specialists.\\n\\nOn September 1st 2016 Zacco expanded its range of services within Intellectual Property (IP) by introducing a new business area ”Innovation Technology”. The core focus of Zacco will remain on IP, but now the scope will be broadened. By launching this new business area, Zacco now offers additional strategic services to our clients; thereby pushing the boundaries in the cross field between Intellectual Property – Advanced Software and Systems – Information and IT Security.\\n\\nVi söker nu en IT-intresserad och driven rekryterare som ska hjälpa oss att hitta de bästa medarbetarna till vårt team. För rätt person finns det goda möjligheter för utveckling inom företaget!\\n\\nArbetsbeskrivning\\nSom IT-rekryterare hos oss har du en viktig roll i att bidra till vår tillväxt och framgång. Dina arbetsuppgifter kommer bl.a. att innebära:\\n\\n• Kartlägga kompetens på arbetsmarknaden\\n\\n• Aktivt söka upp och kontakta kandidater\\n\\n• Nätverka och delta på events för att representera företaget\\n\\n• Intervjua kandidater och säkerställa deras kompetens\\n\\nKvalifikationer\\nVi söker dig som har en utbildning inom HR eller erfarenhet som kan bedömas som likvärdig. Du har erfarenhet av search, och har med fördel ett nätverk inom IT. Har du jobbat i LinkedIn Recruiter eller andra search-verktyg är det meriterande. Svenska och engelska behärskar du obehindrat.\\n\\nFör att lyckas i denna roll ser vi att du trivs i sociala sammanhang där du får representera företaget. Du har en säljande personlighet och är inte rädd för att ta kontakt med människor.\\n\\nFör oss är det viktigt att all kompetens på arbetsmarknaden tillvaratas. Vi välkomnar alla sökande och eftersträvar mångfald.\\n\\nUppdragsgivare: Zacco Innovation Technology Öresund AB\\n\\nOrt: Malmö\\n\\nOmfattning: Heltid\\n\\nSista ansökningsdag: Välkommen med din ansökan via Randstads rekryteringssystem senast den 12/12.\\n\\nFör information: För frågor kontakta Eleonora Cronholm, eleonora.cronholm@randstad.se eller 0725-786450. För mer information om företaget gå in på http://www.zacco.com/about-zacco.\",\n" +
                "        \"yrkesbenamning\": \"Researcher, rekrytering\",\n" +
                "        \"yrkesid\": 6440,\n" +
                "        \"publiceraddatum\": \"2016-12-02T16:41:29.963+01:00\",\n" +
                "        \"antal_platser\": \"1\",\n" +
                "        \"kommunnamn\": \"Malmö\",\n" +
                "        \"kommunkod\": 1280,\n" +
                "        \"antalplatserVisa\": 1,\n" +
                "        \"anstallningstyp\": \"Vanlig anställning\"\n" +
                "      },\n" +
                "      \"villkor\": {\n" +
                "        \"varaktighet\": \"Tillsvidare\",\n" +
                "        \"arbetstid\": \"Heltid\",\n" +
                "        \"arbetstidvaraktighet\": \"Heltid\\r\\nTillsvidare\",\n" +
                "        \"lonetyp\": \"Fast månads- vecko- eller timlön\",\n" +
                "        \"loneform\": \"Fast lön\"\n" +
                "      },\n" +
                "      \"ansokan\": {\n" +
                "        \"referens\": \"201007441\",\n" +
                "        \"webbplats\": \"https://www.randstad.se/JobPageRedirect.ashx?Reference=201007441&Jobsite=AMS&Brand=RandstadSE\",\n" +
                "        \"sista_ansokningsdag\": \"2016-12-12T00:00:00+01:00\",\n" +
                "        \"ovrigt_om_ansokan\": \"\"\n" +
                "      },\n" +
                "      \"arbetsplats\": {\n" +
                "        \"arbetsplatsnamn\": \"Proffice Sverige AB\",\n" +
                "        \"postnummer\": \"21532\",\n" +
                "        \"postadress\": \"Styrmansgatan 2\",\n" +
                "        \"postort\": \"MALMÖ\",\n" +
                "        \"postland\": \"Sverige\",\n" +
                "        \"land\": \"Sverige\",\n" +
                "        \"besoksadress\": \"Styrmansgatan 2, 21118 MALMÖ\",\n" +
                "        \"logotypurl\": \"http://api.arbetsformedlingen.se/platsannons/6965402/logotyp\",\n" +
                "        \"kontaktpersonlista\": {\n" +
                "          \"kontaktpersondata\": [\n" +
                "            {\n" +
                "              \"namn\": \"Eleonora Cronholm\",\n" +
                "              \"telefonnummer\": \"0725-786450\",\n" +
                "              \"epostadress\": \"eleonora.cronholm@randstad.se\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"krav\": {\n" +
                "        \"egenbil\": false\n" +
                "      },\n" +
                "      \"tags\": [\n" +
                "        \"Human Resource\",\n" +
                "        \"Network\",\n" +
                "        \"Recruitment\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"platsannons\": {\n" +
                "      \"annons\": {\n" +
                "        \"annonsid\": \"20662027\",\n" +
                "        \"platsannonsUrl\": \"http://www.arbetsformedlingen.se/ledigajobb?id=20662027\",\n" +
                "        \"annonsrubrik\": \"Javautvecklare till ledande IT-säkerhetsföretag\",\n" +
                "        \"annonstext\": \"På uppdrag åt vår kund, som är ett av Sveriges mest kompetenta bolag inom IT-säkerhet, letar vi nu efter en en duktig Javautvecklare.\\n\\nSom utvecklare kommer du ingå i utvecklingsteamet, en unik samling av IT-experter som genom sin starka passion och kompetens påverkar utvecklingen inom IT-säkerhet både i Sverige och internationellt. Tillsammans utvecklar vi system med extremt höga säkerhets-, prestanda- och tillgänglighetskrav åt myndigheter, organisationer och ledande företag över hela världen.\\n\\nOBS! Våra krav för anställning är mycket höga. Vi söker dig som tillhör marknadens främsta inom ditt kompetensområde, och hela tiden strävar efter att lära dig ännu mer.\\n\\nVår unika företagskultur bygger på att bolaget finns till för oss anställda. Det skapar obegränsade utvecklingsmöjligheter för dig och all möjlighet att påverka vår verksamhets fortsatta utveckling.\\n\\nProfilen vi söker:\\n- Mångårig erfarenhet som utvecklare i Java EE, Spring eller motsvarande\\n- Stort intresse för kvalitet, prestanda- och tillgänglighetskrav\\n- Stort intresse för IT-säkerhet (och vill lära sig ännu mer)\\n- Arbetat med Scrum, Kanban eller motsvarande \\n- Universitetsexamen, högskoleutbildning inom datateknik, datavetenskap eller motsvarande \\n- Laglydig och ostraffad, vi arbetar med SUA-klassade uppdrag och utför regelbundna kontroller av vår personal\\n- Du behärskar engelska och svenska väl i tal och skrift\\n\\nI rollen som utvecklare kommer du:\\n- Ha en avgörande roll i vår fortsatta expansion vad gäller säker utveckling och regionalt i Malmö/Köpenhamn\\n\\nMeriterande\\n- Tillämpningar inom krypto/säkerhet\\n- Microservices-arkitektur\\n- Storskaliga distribuerade system\\n- JBoss\\n- Spring boot\\n- Docker\\n\\nOm Jobshark\\nJobshark erbjuder rekryteringstjänster för IT-sektorn. Bland våra kunder ingår Footway, Bahnhof, Knightec, Sigma Technology, Cygni, Barium, bygghemma.se, Filimundus, TrueSec, Antura, Outnorth, Greatdays, Saldab, Hemverket, Zmarta, Watty, Starweb, Dorunner, Phonera, Alten, Goo Technologies, System Verification, Nyheter24, Vendemore, Trustly och Softronic. Jobshark ingår i en företagsgrupp med ca 50 anställda.\",\n" +
                "        \"yrkesbenamning\": \"Systemutvecklare/Programmerare\",\n" +
                "        \"yrkesid\": 2419,\n" +
                "        \"publiceraddatum\": \"2016-11-28T00:00:00+01:00\",\n" +
                "        \"antal_platser\": \"1\",\n" +
                "        \"kommunnamn\": \"Malmö\",\n" +
                "        \"kommunkod\": 1280,\n" +
                "        \"antalplatserVisa\": 1,\n" +
                "        \"anstallningstyp\": \"Vanlig anställning\"\n" +
                "      },\n" +
                "      \"villkor\": {\n" +
                "        \"varaktighet\": \"Tillsvidare\",\n" +
                "        \"arbetstid\": \"Heltid\",\n" +
                "        \"lonetyp\": \"Fast månads- vecko- eller timlön\"\n" +
                "      },\n" +
                "      \"ansokan\": {\n" +
                "        \"webbplats\": \"https://www.jobshark.se/public/jobs/view/231?src=ABF\",\n" +
                "        \"sista_ansokningsdag\": \"2016-12-26T23:59:59+01:00\",\n" +
                "        \"ovrigt_om_ansokan\": \"Du hittar mer information om tjänsten och ansöker via vår jobbportal (via e-mail): https://www.jobshark.se/public/jobs/view/231?src=ABF\\n\\nAlla ansökningar hanteras självfallet strikt konfidentiellt. Inkomna ansökningar hanteras löpande.\"\n" +
                "      },\n" +
                "      \"arbetsplats\": {\n" +
                "        \"arbetsplatsnamn\": \"Jobshark AB\",\n" +
                "        \"postnummer\": \"37133\",\n" +
                "        \"postadress\": \"Östra Vittusgatan 36\",\n" +
                "        \"postort\": \"Karlskrona\",\n" +
                "        \"postland\": \"Sverige\",\n" +
                "        \"land\": \"Sverige\",\n" +
                "        \"besoksadress\": \"Östra Vittusgatan 36\",\n" +
                "        \"besoksort\": \"Karlskrona\",\n" +
                "        \"epostadress\": \"jobshark@jobshark.se\",\n" +
                "        \"logotypurl\": \"http://api.arbetsformedlingen.se/platsannons/20662027/logotyp\",\n" +
                "        \"hemsida\": \"http://www.jobshark.se\"\n" +
                "      },\n" +
                "      \"krav\": {\n" +
                "        \"egenbil\": false\n" +
                "      },\n" +
                "      \"tags\": [\n" +
                "        \"Java\",\n" +
                "        \"Agile\",\n" +
                "        \"Docker\",\n" +
                "        \"Security\"\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "]";
    }

    public static String getSwipesMock() {
        return "[\n" +
                "    {\n" +
                "        \"platsannons\": {\n" +
                "            \"annons\": {\n" +
                "                \"annonsid\": \"7114219\",\n" +
                "                \"annonsrubrik\": \"Relationsfokuserad backendutvecklare till Per & Per\",\n" +
                "                \"annonstext\": \"För dig som vill utvecklas som backend-utvecklare finns nu chansen att bli en del av det härliga teamet på IT-Bolaget Per &amp; Per. Vill du variera det tekniska uppdraget som utvecklare med kundkontakt och service, samtidigt som du erbjuds utvecklingsmöjligheter i ett härligt gäng, då har du hittat helt rätt! \\n\\nOM TJÄNSTEN \\nIt-bolaget Per &amp; Per levererar skräddarsydda IT-lösningar till sina kunder. Att leverera kundanpassade mobilappar för användning i fält innebär både täta kundkontakter men också att arbeta i teknikens absoluta framkant. Academic Work söker därför nu för Per &amp; Pers räkning en framåttänkande systemutvecklare som kommer vara en del av deras backendutveckling. \\n\\nDen här rekryteringsprocessen hanteras av Academic Work och Per &amp; Pers önskemål är att alla samtal och mail kring tjänsten går till\\n AcademicWork\\n\\nUppdraget är en del av vår personaluthyrning. Du kommer vara anställd av Academic Work och arbeta som konsult hos Per &amp; Per. Deras intention är att du på sikt ska kunna bli anställd direkt hos dem, förutsatt att alla parter är nöjda med samarbetet.\\n\\nARBETSUPPGIFTER \\nSom backendutvecklare kommer du få ta del av ett systemutvecklingsprojekts hela resa. Din huvudsakliga uppgift kommer vara att utveckla skräddarsydda funktioner efter våra kunders behov, men du kommer även att ha en hel del kundkontakt och medverka vid exempelvis workshops och designmöten. Du kommer att ingå i ett team om upp till fyra personer som stöttar varandra i det dagliga arbetet. \\n\\nDu kommer till exempel att: \\n* Utveckla backend-tjänster för de mobilappar som vi tar fram åt våra kunder.\\n* Bygga integrationer mot våra kunders verksamhetssystem.\\n* Träffa kunder och diskutera allt från krav på nya funktioner till återkoppling på tidigare leveranser.\\n\\nTjänsten passar dig som gillar att tänka kreativt och arbeta i små team för att plocka fram för kunden skräddarsydda lösningar. Du är bra på att analysera krav från beställare och därefter på egen hand ta fram smarta lösningar. Du kommer ha ett stort inflytande över din egen tid, vilket ställer krav på din förmåga att kunna planera och strukturera ditt arbete. \\n\\nPå Per &amp; Per erbjuds du möjligheter till kompetensutveckling, regelbundna medarbetarsamtal samt en individuell utvecklingsplan. Vi söker därför dig som ständigt är sugen på att ta nästa steg och utvecklas både inom din yrkesroll och som person.\\n\\nVI SÖKER DIG SOM \\nVi söker dig som:\\n* Har en minst 3-årig högskoleexamen inom systemvetenskap, dataingenjör eller likvärdig utbildning.\\n* Har god programmeringsvana och kan C# och .Net eller känner att det är något som du verkligen skulle vilja lära dig.\\n\\nDet är meriterande om du:\\n*Har erfarenhet av programmering.\\n*Har erfarenhet av service, kommunikation och kundbemötande.\\n\\nVi lägger stor vikt vid personlig lämplighet och vi ser gärna att du är en lagspelare som trivs bra att arbeta i team, som med gemensamma krafter verkar mot ett mål. Du är kommunikativ i ditt sätt att arbeta och kan tydligt förmedla dina tankar och idéer till andra teammedlemmar samt är inte rädd att be om råd i obekanta situationer. Du är driven och sugen på att ständigt erövra ny information för att därmed växa som person tillsammans med företaget. \\n\\nPå Per &amp; Per är det högt i tak och man värnar om att det är bra stämning i gruppen. Bland de anställda finns ett gemensamt intresse för friluftsliv och idrott, vilket ofta innebär att konferenser och teambuilding kantas av fysiska aktiviteter.  \\n\\nÖVRIG INFORMATION  \\n\\n\\n* Start: Omgående\\n* Omfattning: Heltid\\n* Placering: Linköping\\n* Sök tjänsten genom att klicka på Ansök nedan. Vi går igenom urvalet löpande och annonsen kan stängas ner innan tjänsten är tillsatt om vi gått över till urvals- och intervjufasen.\\n* Vi tar inte emot ansökningar via mail men har du specifika frågor kring tjänsten besvaras dessa på lin01@academicwork.se under kontorstid. Skriv annonstiteln i rubriken och kopiera gärna in länken till annonsen i ditt mail. För generella funderingar kring din ansökan/vår rekryteringsprocess finns vi ofta tillgängliga i chatten här på webben under vardagar, hör gärna av dig där!\\n\\n\\nAcademic Work är Home of the Young Professionals. Vi vänder oss till dig som är akademiker och fortfarande studerar på högskola/universitet, är nyutexaminerad eller har några års arbetslivserfarenhet. \\n\\n\\n* Vårt erbjudande till dig som heltidskonsult hos Academic Work inkluderar utöver kollektivavtalsenliga villkor och dedikerad konsultchef också rabatter och erbjudanden genom vår konsultportal. Läs mer om vårt erbjudande här\\n\\n\\nSKYDD FÖR DIN PERSONLIGA INTEGRITET\\n\\nNär du skickar in din ansökan till Academic Work godkänner och samtycker du till att Academic Work behandlar dina personuppgifter enligt Personuppgiftslagen. Läs mer under vår PuL-sida.\\n\\nINFORMATION OM FÖRETAGET \\nIT-Bolaget Per &amp; Per är ett litet företag med en platt organisation. Vi jobbar idag mot kunder runt om i Norden, de flesta inom skogsbranschen. Alla som jobbar på Per &amp; Per har kontakt med våra kunder och även andra företag som vi samarbetar med. De appar vi utvecklar har tagits emot väl och är viktiga verktyg i det dagliga arbetet. Framgången har gett mersmak och vår ambition är att växa och nå fler kunder både i Sverige och internationellt.\",\n" +
                "                \"anstallningstyp\": \"Vanlig anställning\",\n" +
                "                \"antal_platser\": \"1\",\n" +
                "                \"antalplatserVisa\": 1,\n" +
                "                \"kommunkod\": 580,\n" +
                "                \"kommunnamn\": \"Linköping\",\n" +
                "                \"platsannonsUrl\": \"http://www.arbetsformedlingen.se/ledigajobb?id=7114219\",\n" +
                "                \"publiceraddatum\": \"2017-03-22T12:00:51.653+01:00\",\n" +
                "                \"yrkesbenamning\": \"Systemutvecklare/Programmerare\",\n" +
                "                \"yrkesid\": 2419\n" +
                "            },\n" +
                "            \"ansokan\": {\n" +
                "                \"ovrigt_om_ansokan\": \"\",\n" +
                "                \"referens\": \"14984857\",\n" +
                "                \"sista_ansokningsdag\": \"2017-04-22T00:00:00+02:00\",\n" +
                "                \"webbplats\": \"http://www.academicwork.se/jobad/relationsfokuserad-backendutvecklare-till-per-per/14984857?apply=1\"\n" +
                "            },\n" +
                "            \"arbetsplats\": {\n" +
                "                \"arbetsplatsnamn\": \"Academic Work\",\n" +
                "                \"besoksadress\": \"Drottninggatan 23, 582 25 Linköping\",\n" +
                "                \"hemsida\": \"http://www.academicwork.se\",\n" +
                "                \"kontaktpersonlista\": {\n" +
                "                    \"kontaktpersondata\": [\n" +
                "                        {\n" +
                "                            \"namn\": \"Victoria Hencz\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"land\": \"Sverige\",\n" +
                "                \"postadress\": \"Drottninggatan 23\",\n" +
                "                \"postland\": \"Sverige\",\n" +
                "                \"postnummer\": \"58225\",\n" +
                "                \"postort\": \"Linköping\"\n" +
                "            },\n" +
                "            \"krav\": {\n" +
                "                \"egenbil\": false\n" +
                "            },\n" +
                "            \"villkor\": {\n" +
                "                \"arbetstid\": \"Heltid\",\n" +
                "                \"arbetstidvaraktighet\": \"Heltid\\r\\n8-17\",\n" +
                "                \"loneform\": \"Enligt avtal\",\n" +
                "                \"lonetyp\": \"Fast månads- vecko- eller timlön\",\n" +
                "                \"varaktighet\": \"6 månader eller längre\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";
    }
}
