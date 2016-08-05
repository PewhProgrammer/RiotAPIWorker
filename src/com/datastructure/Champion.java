package com.datastructure;

import com.Log.Logger;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class Champion {

    private final Name mName ;
    private final boolean mFreeToPlay ;

    public Champion(int id,boolean freeToPlay){
        mName = getChampionName(id) ;
        mFreeToPlay = freeToPlay ;
    }

    private Name getChampionName(int i){

        for(Name champ : Name.values()){
            if(i == champ.ID){
                return champ ;
            }
        }

        Logger.debug("New Champion found in Champion.java !! ID: " + i);
        System.exit(1);
        return null ;
    }

    public enum Name{
        Shaco(35),
        DrMundo(36),
        Rammus(33),
        Anivia(34),
        Irelia(39),
        Yasuo(157),
        Sona(37),
        Kassadin(38),
        Zac(154),
        Gnar(150),
        Karma(43),
        Corki(42),
        Gangplank(41),
        Janna(40),
        Jhin(202),
        Kindred(203),
        Braum(201),
        Ashe(22),
        Tryndamere(23),
        Jax(24),
        Morgana(25),
        Zilean(26),
        Singed(27),
        Evelynn(28),
        Twitch(29),
        Galio(3),
        Velkoz(161),
        Olaf(2),
        Taliyah(163),
        Annie(1),
        Leblanc(7),
        Karthus(30),
        Urgot(6),
        Xinzhao(5),
        Amumu(32),
        TwistedFate(4),
        Chogath(31),
        FiddleSticks(9),
        Vladimir(8),
        Warwick(19),
        Teemo(17),
        Tristana(18),
        Sivir(15),
        Soraka(16),
        Ryze(13),
        Sion(14),
        MasterYi(11),
        Alistar(12),
        MissFortune(21),
        Nunu(20),
        Rengar(107),
        Volibear(106),
        Fizz(105),
        Graves(104),
        Ahri(103),
        Shyvana(102),
        Lux(99),
        Xerath(101),
        Tresh(412),
        Shen(98),
        Jinx(222),
        Kogmaw(96),
        TahmKench(223),
        Riven(92),
        Talon(91),
        Malzahar(90),
        Kayle(10),
        Kalista(429),
        Reksai(421),
        Illaoi(420),
        Leona(89),
        Gragas(79),
        Lulu(117),
        Poppy(78),
        fiora(114),
        Udyr(77),
        Ziggs(115),
        Viktor(112),
        Sejuani(113),
        Varus(110),
        Nautilus(111),
        Draven(119),
        Bard(432),
        Mordekaiser(82),
        Ekko(245),
        Yorick(83),
        Pantheon(80),
        Ezreal(81),
        Garen(86),
        Akali(84),
        Kennen(85),
        Vayne(67),
        Jayce(126),
        Cassiopeia(69),
        Lissandra(127),
        Rumble(68),
        Khazix(121),
        Darius(122),
        Hexarim(120),
        Skarner(72),
        Lucian(236),
        Heimerdinger(74),
        Nasus(75),
        Zed(238),
        Nidalee(76),
        Syndra(134),
        Quinn(133),
        JarvanIV(59),
        Renektion(58),
        Maokai(57),
        AurelionSol(136),
        Nocturne(56),
        Katarina(55),
        Leesin(64),
        MonkeyKing(62),
        Brand(63),
        Azir(268),
        Elise(60),
        Diana(131),
        Nami(267),
        Orianna(61),
        Aatrox(266),
        Zyra(143),
        Trundle(48),
        Veigar(45),
        Taric(44),
        Caitlyn(51),
        Blitzcrank(53),
        Malphite(54),
        Vi(254),
        Swain(50);

        private final int ID;
        Name(int id){
            ID = id ;
        }


    }

    @Override
    public String toString(){
        return mName.toString() ;
    }
}
