import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
            new Integer[]{1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14},
            1,
            new Integer[]{1,2,3,4,null,null,7,8,9,null,14}
        );
        test(
            new Integer[]{5,4,8,11,null,17,4,7,1,null,null,5,3},
            22,
            new Integer[]{5,4,8,11,null,17,4,7,null,null,null,5}
        );
        
        // my case
        test(
            new Integer[]{1,-2},
            0,
            new Integer[]{}
        );
        test(
            new Integer[]{1,-2,-3},
            0,
            new Integer[]{}
        );
    
        // wrong judge case in contest 140
        /*
        test(
            new Integer[]{
                714,839,967,246,703,-418,455,-900,23,-583,
                -736,603,726,-634,384,954,-760,922,23,-357,
                8,-577,121,-671,-812,-385,705,-885,353,-70,
                42,706,218,-566,-295,-620,-699,141,104,-966,
                559,581,-402,null,null,677,757,-431,-807,169,
                262,-874,168,null,null,-401,207,-235,-23,-378,
                -185,-74,-864,273,602,79,-234,-385,-475,971,
                22,-865,-713,-814,393,68,32,-730,898,-657,
                572,-726,718,-640,-839,-231,852,201,339,11,
                516,730,-514,714,-401,7,567,-745,-422,71,
                -881,-836,180,-523,-411,-248,788,null,null,-400,
                323,915,-636,-939,-550,-336,500,-601,36,43,
                -872,-362,21,null,null,null,null,489,880,null,
                null,null,null,null,null,null,318,-342,171,-422,
                93,302,569,991,869,-308,674,32,699,32,
                -589,913,811,null,822,null,-415,-781,null,-175,
                null,null,-940,-670,-114,809,null,-248,-445,278,
                -944,null,null,659,-237,369,100,-654,-419,191,
                -390,-583,124,null,755,263,-775,null,50,-609,
                -54,-319,579,null,null,-853,-153,-775,514,853,
                -45,790,-53,395,861,null,-818,null,null,null,
                -392,253,null,862,null,375,null,-843,-538,-417,
                -211,810,null,85,92,null,null,-174,-717,-942,
                175,-641,682,null,-132,-369,-659,139,-830,-206,
                343,null,-330,-897,-549,-509,240,-611,null,null,
                null,930,-239,-950,559,729,-616,-337,350,863,
                -38,851,-872,null,null,-267,394,null,720,778,
                408,-560,304,null,null,-675,535,null,null,null,
                667,null,-796,-733,null,null,null,-680,138,-909,
                null,169,944,null,3,825,-173,-615,-720,null,
                115,-260,214,784,null,-485,null,18,188,870,
                null,-659,-232,170,715,318,6,649,null,-320,
                -742,null,null,null,null,657,null,763,null,-280,
                278,163,93,574,498,null,920,-904,-82,-427,
                null,-789,null,null,609,889,-736,334,-481,-603,
                203,null,991,null,null,null,23,-480,-537,-289,
                null,null,null,-932,-935,97,-526,537,-950,149,
                -419,null,803,-898,null,null,null,null,-843,null,
                -418,596,809,-824,null,null,811,180,null,794,
                523,781,-502,-196,-475,798,-601,-229,336,null,
                -628,null,-699,null,352,-616,788,613,-204,-641,
                902,144,-196,-199,null,null,null,-792,null,null,
                null,-422,null,302,584,468,499,9,-364,768,
                -937,271,-167,-37,null,-270,-696,-543,-245,null,
                622,891,-91,null,472,null,12,-659,-796,null,
                -290,250,-305,null,null,-881,-58,988,null,null,
                173,null,null,null,null,null,null,-998,-192,1000,
                802,333,435,-212,872,624,382,919,392,518,
                null,414,null,323,670,null,null,462,706,173,
                -304,null,null,565,-434,400,-198,null,null,-728,
                null,479,null,null,985,null,-221,-611,403,915,
                null,null,null,null,null,null,null,null,null,796,
                -323,null,844,null,null,null,null,null,null,null,
                237,null,null,-184,-273,-613,null,402,-301,null,
                null,null,739,568,-378,963,638,-269,-87,863,
                -475,-799,-950,-76,-83,null,-686,null,null,null,
                null,null,723,423,815,204,-752,181,-24,null,
                -506,null,null,null,-941,-60,null,null,null,null,
                null,null,null,null,840,null,null,-792,null,null,
                null,null,null,54,-313,null,null,null,231,97,
                null,-309,398,21,-87,null,-322,-711,null,903,
                null,-437,-95,null,-926,null,null,-415,726,null,
                -274,-106,-93,-774,60,-54,443,-593,302,-655,
                null,473,-715,-772,897,-846,null,null,-215,790,
                null,-997,null,561,-956,null,null,-680,-693,813,
                -153,510,705,-732,-14,null,null,-187,null,33,
                273,null,887,null,null,null,-64,-844,68,-159,
                -964,-332,null,-390,null,null,-675,null,null,-565,
                -749,-443,207,715,906,null,null,-993,259,837,
                -602,181,606,710,null,351,-189,-112,877,null,
                70,null,null,null,null,null,null,null,null,null,
                null,null,-548,null,430,null,90,null,652,null,
                null,null,null,146,507,-301,-170,null,null,null,
                -934,null,71,null,null,-783,null,null,null,null,
                466,-148,-908,768,null,null,null,null,-955,157,
                null,null,null,502,null,null,null,-875,null,-429,
                41,488,-414,null,-445,174,null,678,null,null,
                null,null,752,null,null,-249,null,null,null,null,
                null,-330,null,null,null,-553,null,null,null,893,
                null,null,null,129,-788,236,-414,-273,null,null,
                null,null,883,null,764,821,-818,-80,null,-943,
                -573,541,null,-993,null,578,-889,-107,345,null,
                556,null,null,-661,-645,997,-432,-374,-6,null,
                null,null,null,-984,null,null,null,null,-213,null,
                null,800,-45,null,null,412,null,-806,-352,null,
                null,-679,463,-811,null,null,null,null,null,null,
                null,819,-631,542,615,null,731,-538,928,null,
                null,282,982,-770,-991,null,null,null,-719,555,
                null,null,null,null,null,null,366,-884,null,-304,
                null,-882,null,166,null,null,null,-665,null,null,
                null,null,-114,-622,-134,null,null,null,null,null,
                null,-173,null,877,null,-346,null,-303,244,-738,
                222,900,-319,null,-627,null,23,null,-687,-445,
                530,73,null,134,784,-455,null,null,null,null,
                783,-377,null,null,null,null,null,212,180,-75,
                null,-575,-82,-447,-658,null,755,null,-676,262,
                71,-980,-673,null,-465,-510,null,-214,-252,16,
                -522,52,null,null,null,493,-420,-923,-667,null,
                -325,-105,-480,null,-784,-701,null,-351,null,null,
                null,null,null,null,null,null,null,-613,313,509,
                -851,728,-380,-690,null,null,547,null,null,443,
                -238,-280,null,954,400,null,null,null,678,null,
                null,null,406,null,null,null,213,389,680,null,
                -214,-635,603,null,118,null,-221,null,106,-916,
                null,null,-101,null,null,null,null,null,null,677,
                null,494,null,707,-847,516,-512,null,null,567,
                null,774,null,533,null,999,849,493,40,378,
                860,581,null,-192,236,null,null,null,null,-397,
                -68,null,null,null,null,null,null,null,null,null,
                null,null,745,245,651,null,null,null,null,null,
                null,532,null,null,-938,null,null,null,null,null,
                null,303,-738,-93,-844,884,-977,null,721,null,
                null,null,null,null,null,null,null,null,null,null,
                -970,null,null,315,null,null,null,760,null,null,
                52,-249,-243,-409,null,null,null,null,null,null,
                null,null,null,601,191,975,143,null,null,-53,
                816,-1,null,null,null,554,null,null,17,null,
                null,242,null,null,null,null,null,null,null,207,
                161,null,null,-559,-599,null,null,-459,null,-716,
                964,null,null,386,697,532,-890,null,-81,null,
                null,884,null,null,null,null,null,null,-862,-586,
                216,-834,null,null,null,-404,null,null,null,null,
                null,null,null,-62,-970,null,null,62,749,527,
                465,-933,-638,null,240,null,-68,null,null,null,
                null,439,-816,-529,-143,51,388,null,null,null,
                -763,null,-350,null,908,null,-428,-516,null,null,
                464,null,null,null,null,null,158,-813,404,null,
                null,-665,648,null,-17,-810,-338,null,null,null,
                null,-376,-37,null,-380,657,null,null,null,235,
                null,206,125,null,null,null,null,null,null,null,
                null,-400,null,-807,null,null,null,null,112,null,
                null,null,210,null,null,-189,-170,385,-941,null,
                -878,-389,531,988,435,null,null,null,null,null,
                -452,null,null,null,null,null,-15,-418,null,454,
                null,null,null,-475,-293,null,null,-520,343,-543,
                null,null,-856,817,null,null,null,null,225,null,
                null,null,null,null,null,-124,-283,null,null,null,
                -654,-205,713,null,-14,null,-904,null,null,-837,
                666,null,null,null,981,952,null,null,null,-769,
                null,873,null,568,329,-815,null,null,null,-639,
                -299,null,null,null,null,-474,null,-56,null,-895,
                null,null,563,null,-854,null,184,null,null,null,
                750,286,-671,-975,null,null,null,-355,-892,-144,
                -238,433,null,null,null,null,null,null,181,null,
                null,849,null,null,992,-630,-399,null,-802,null,
                null,-709,-853,-190,10,null,null,null,null,null,
                null,null,-404,null,null,null,-991,null,-50,null,
                null,null,null,347,-299,-138,978,null,null,-650,
                null,null,null,-127,906,null,null,null,null,null,
                null,null,null,null,null,-892,631,null,null,879,
                null,674,655,null,56,-106,null,null,null,792,
                322,-253,null,null,null,null,null,null,null,null,
                null,null,-404,null,null,null,null,null,null,null,
                null,null,null,null,-906,null,null,-921,616,null,
                null,757,null,-850,-289,null,12,null,null,null,
                null,null,null,null,null,null,-546,null,null,-672,
                null,null,null,-561,null,-713,null,null,null,null,
                null,null,-523,-71,null,924,null,null,null,null,
                352,null,null,null,-832,null,null,null,null,209,
                null,null,null,null,-321,770,null,null,null,null,
                944,null,74,239,-816,null,null,-233,555,null,
                null,null,null,null,null,null,null,null,899,726,
                null,null,null,143,129,null,764,null,-145,null,
                null,-55,231,null,993,null,null,null,null,null,
                null,null,null,-559,847,null,null,-56,299,-544,
                316,-11,809,null,null,null,null,null,-137,null,
                null,null,null,193,null,707,null,-177,null,null,
                -566,null,-50,null,null,438,null,null,null,null,
                null,-129,-288,-209,-422,-943,-771,null,-784,-570,
                null,-584,-774,null,null,-512,null,null,null,null,
                null,null,null,null,null,172,441,null,null,null,
                null,-285,null,null,null,138,332,null,35,null,
                null,null,null,null,null,-265,null,null,null,null,
                -458,null,null,null,null,null,null,null,null,null,
                null,null,976,null,null,null,967,null,-672,null,
                null,null,null,null,334,null,null,806,null,357,
                null,-574,58,null,null,null,-943,null,null,-77,
                null,null,380,719,519,58,-680,null,-573,null,
                null,null,-798,null,null,243,-767,805,803,826,
                -934,null,-335,624,540,null,null,-698,null,null,
                405,null,null,null,222,null,null,null,null,null,
                null,12,null,null,null,null,null,918,-821,null,
                null,-951,-750,799,null,null,null,null,null,null,
                440,null,null,-267,null,null,null,297,null,null,
                365,null,null,null,232,null,null,null,null,null,
                null,null,null,-769,449,null,null,null,245,656,
                null,null,null,962,-123,-301,909,959,null,null,
                null,null,null,null,null,null,-966,null,null,null,
                null,null,null,null,-307,-767,798,null,null,null,
                null,null,null,null,null,-638,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,
                null,null,-314,null,null,null,167,null,null,409,
                null,null,null,null,null,null,null,null,null,null,
                null,-918,-413,36,null,482,null,-724,704,-25,
                390,707,null,null,null,null,-485,null,null,null,
                null,null,null,null,null,null,null,null,null,-121,
                238,460,null,null,null,188,100,274,987,544,
                null,null,null,-395,null,null,null,-753,null,null,
                null,-746,null,152,null,null,null,null,null,735,
                392,null,null,null,null,null,null,-790
            },
            -2,
            new Integer[]{
                714,839,967,246,703,-418,455,-900,23,-583,
                -736,603,726,-634,384,954,-760,922,23,-357,
                8,-577,121,-671,-812,-385,705,-885,353,-70,
                42,706,218,-566,-295,-620,-699,141,104,-966,
                559,581,-402,null,null,677,757,-431,-807,169,
                262,-874,168,null,null,-401,207,-235,-23,-378,
                -185,-74,-864,273,602,79,-234,-385,null,971,
                null,-865,-713,-814,393,68,32,-730,898,-657,
                572,-726,718,-640,-839,-231,852,201,339,11,
                516,730,-514,714,-401,7,567,-745,-422,71,
                null,-836,180,-523,-411,-248,788,null,null,-400,
                323,915,-636,-939,-550,-336,500,-601,36,43,
                -872,-362,21,null,null,null,null,489,880,null,
                null,null,318,-342,171,-422,93,302,569,991,
                869,-308,674,32,699,32,-589,913,811,null,
                822,null,-415,-781,null,-175,null,null,-940,-670,
                -114,809,null,-248,-445,278,-944,null,null,659,
                -237,369,100,null,-419,191,-390,-583,124,null,
                755,263,-775,null,50,-609,-54,-319,579,-853,
                -153,-775,514,853,-45,790,-53,395,861,null,
                -818,null,null,null,-392,253,null,862,null,375,
                null,-843,-538,-417,-211,810,null,85,92,null,
                null,-174,-717,-942,175,-641,682,null,-132,-369,
                null,139,-830,-206,343,null,-330,-897,-549,-509,
                240,-611,null,null,null,930,-239,-950,559,729,
                -616,-337,350,863,-38,851,-872,null,null,-267,
                394,null,720,778,408,-560,304,null,null,-675,
                535,null,null,null,667,null,null,null,null,null,
                null,-680,138,-909,null,169,944,null,3,825,
                -173,-615,-720,null,115,-260,214,784,null,18,
                188,870,null,-659,-232,170,715,318,6,649,
                null,-320,-742,null,null,null,null,657,null,763,
                null,-280,278,163,93,574,498,null,920,-904,
                -82,-427,null,-789,null,null,609,889,null,334,
                null,-603,203,null,991,null,null,null,23,-480,
                -537,-289,null,null,null,-932,null,97,-526,537,
                -950,149,-419,null,803,-898,null,null,null,null,
                -843,null,-418,596,809,-824,null,null,811,180,
                null,794,523,781,null,798,null,null,336,null,
                -628,null,-699,null,352,-616,788,613,-204,null,
                902,144,-196,-199,null,null,null,-792,null,null,
                null,-422,null,302,584,468,499,9,-364,768,
                -937,271,-167,-37,null,-270,-696,null,-245,null,
                622,891,-91,null,472,null,12,-659,-796,null,
                -290,250,-305,null,null,-881,-58,988,null,null,
                null,null,null,-998,-192,1000,802,333,435,-212,
                872,624,382,919,392,518,null,414,null,323,
                670,null,null,462,706,173,-304,565,null,400,
                -198,null,null,null,null,479,null,null,985,null,
                -221,null,403,915,null,null,null,null,null,null,
                null,null,null,796,-323,null,844,null,null,null,
                null,null,null,null,237,null,null,-184,-273,null,
                null,402,-301,null,null,null,739,568,null,963,
                638,863,-475,-76,-83,null,-686,null,null,null,
                null,null,723,423,815,204,-752,181,null,null,
                null,null,null,-60,null,null,null,null,null,null,
                null,null,840,null,null,-792,null,null,null,null,
                null,54,-313,null,null,null,231,97,null,-309,
                398,21,-87,null,null,null,-926,null,-274,-106,
                -93,-774,60,-54,443,null,302,-655,null,473,
                -715,-772,897,null,-215,790,null,null,null,561,
                null,null,null,-680,-693,813,-153,510,705,-732,
                -14,null,null,-187,null,33,273,null,887,null,
                null,null,-64,-844,68,-159,-964,-332,null,-390,
                null,null,null,-565,-749,-443,207,715,906,null,
                null,-993,259,837,null,181,606,710,null,351,
                -189,-112,877,null,70,null,null,null,null,null,
                null,null,null,null,-548,null,430,null,90,null,
                652,null,null,null,null,146,507,-301,-170,null,
                null,null,-934,null,71,null,null,-783,null,null,
                null,null,466,-148,-908,768,null,null,null,null,
                -955,null,null,502,null,-875,null,-429,41,488,
                -414,174,null,678,null,null,null,null,752,null,
                null,-249,null,null,null,null,null,null,null,-553,
                null,null,null,893,null,129,-788,236,-414,null,
                883,null,764,null,-573,541,null,null,null,578,
                -889,-107,345,null,556,null,null,-661,-645,997,
                -432,-984,null,null,null,null,-213,null,null,800,
                -45,null,null,412,null,-806,-352,null,null,-679,
                463,-811,null,null,731,null,982,-770,-991,null,
                null,null,null,555,null,null,null,null,null,null,
                null,-304,null,-882,null,166,null,null,null,-665,
                null,null,-114,-622,-134,null,null,-173,null,877,
                null,-346,null,-303,244,-738,222,900,-319,null,
                -627,null,23,null,-687,-445,530,73,null,134,
                784,-455,null,null,null,null,783,-377,null,null,
                null,null,null,212,180,-575,-82,-447,-658,null,
                755,null,-676,262,71,-980,-673,null,-465,-510,
                null,-214,-252,52,null,null,null,493,-420,-923,
                -667,null,-325,-105,null,null,-784,-701,null,-351,
                null,null,null,null,null,null,null,null,null,-613,
                313,509,-851,728,-380,null,null,null,547,null,
                null,443,-238,-280,null,954,400,null,null,null,
                678,null,406,null,null,null,213,389,680,null,
                -214,null,603,null,-221,null,106,-916,null,null,
                -101,null,null,null,null,677,null,494,null,707,
                -847,516,-512,567,null,774,null,581,null,-192,
                236,null,null,-397,-68,null,null,null,null,null,
                null,null,null,null,null,null,745,245,651,null,
                null,532,null,null,-938,null,null,null,null,null,
                null,303,-738,-93,-844,884,-977,null,721,null,
                null,null,null,760,null,null,52,-409,null,null,
                null,null,null,601,191,975,143,null,null,-53,
                816,-1,null,null,null,554,null,null,17,null,
                null,242,null,null,null,null,null,null,null,207,
                161,null,null,-559,-599,null,null,-459,null,-716,
                964,null,null,386,697,532,-890,null,-81,null,
                null,884,null,null,null,null,null,-586,216,-834,
                null,null,null,-404,null,null,null,null,null,null,
                null,-62,-970,null,null,62,749,527,465,-933,
                -638,null,240,null,-68,439,null,-529,-143,null,
                388,null,null,null,null,null,-350,null,908,-516,
                null,null,464,null,null,null,null,null,158,-813,
                404,null,null,-665,648,null,-17,null,null,null,
                null,-376,-37,null,-380,657,null,null,null,235,
                null,206,125,null,null,null,null,null,null,null,
                null,null,null,null,112,null,null,null,210,null,
                null,-189,-170,385,-941,null,-878,-389,531,988,
                435,null,null,null,null,null,-452,null,null,-520,
                343,-543,null,null,-856,817,null,null,null,null,
                225,null,null,null,null,null,null,-124,-283,null,
                null,null,-654,-205,713,null,-14,null,-904,null,
                null,null,981,952,null,873,null,568,329,-815,
                null,null,null,-639,-299,null,null,null,null,-474,
                null,-56,null,-895,null,null,563,null,-854,null,
                184,null,null,null,750,286,-671,null,null,null,
                null,-355,-892,-144,-238,433,null,null,null,null,
                null,null,181,849,null,null,992,-630,-399,null,
                -802,null,null,-709,-853,-190,10,null,null,null,
                null,null,null,null,null,null,null,null,-991,null,
                -50,null,null,347,-299,-138,978,null,null,-127,
                906,null,null,null,null,null,null,null,null,-892,
                631,null,null,879,null,674,655,null,56,792,
                322,-253,null,null,null,null,null,null,null,null,
                null,null,-404,null,null,null,null,null,null,null,
                -906,null,null,-921,616,null,null,757,null,-850,
                -289,null,12,null,null,null,null,null,null,-561,
                null,null,null,null,null,null,null,null,null,-71,
                null,924,null,null,null,null,352,null,null,null,
                -832,null,null,null,null,null,-321,null,null,null,
                944,null,74,239,-816,null,null,-233,555,null,
                null,null,null,null,null,null,null,null,899,726,
                null,null,null,143,129,null,764,null,null,-55,
                231,null,993,null,null,null,null,null,null,null,
                null,-559,847,null,null,-56,299,-544,316,-11,
                809,null,null,null,null,null,-137,null,null,193,
                null,707,null,-177,null,null,-566,null,-50,438,
                null,null,null,null,null,-129,-288,-209,-422,-943,
                -771,null,-784,-570,null,null,null,-512,null,null,
                null,null,null,null,null,null,null,172,441,null,
                null,null,null,-285,null,null,null,null,null,-265,
                null,null,null,null,-458,null,null,null,null,null,
                null,null,976,null,null,null,967,null,-672,null,
                null,null,null,null,334,null,null,806,null,357,
                null,null,null,null,-943,null,null,-77,null,null,
                380,719,519,58,-680,null,-573,null,null,null,
                -798,null,null,243,-767,805,803,826,-934,null,
                -335,624,540,null,null,null,null,null,405,null,
                null,null,222,null,null,null,null,null,null,12,
                null,null,null,null,null,-951,-750,799,null,null,
                null,-267,null,null,null,297,null,null,365,null,
                null,null,232,null,null,null,null,-769,449,null,
                null,null,245,656,null,null,null,962,-123,-301,
                909,959,null,null,null,null,null,null,null,null,
                -966,null,null,null,null,null,null,null,-307,-767,
                798,null,null,null,null,null,null,-638,null,null,
                null,null,null,null,null,null,null,null,-314,null,
                null,null,167,null,null,409,null,null,null,null,
                null,null,null,null,null,null,null,-918,-413,36,
                null,482,null,null,704,null,390,707,null,null,
                null,null,-485,null,null,null,null,null,null,null,
                null,null,null,null,null,460,null,188,100,274,
                987,544,null,null,null,-753,null,null,null,-746,
                null,152,null,null,null,735,392
            }
        );
        */
    }
    
    public static void test(Integer[] rroot,int limit,Integer[] expected){
        System.out.println(String.format("root=%s, limit=%d",join(rroot),limit));
        Solution solution = new Solution();
        TreeNode root = toTreeNode(rroot);
        TreeNode result = solution.sufficientSubset(root,limit);
        Integer[] resultAry = toIntArray(result);
        System.out.println(String.format("result=%s",join(resultAry)));
        aassert(Arrays.equals(resultAry, expected));
    }

    public static TreeNode toTreeNode(Integer[] vAry){
        if(vAry.length==0)return null;
        
        TreeNode ret = new TreeNode(vAry[0]);
        
        LinkedList<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.addLast(ret);
        
        int readIdx = 1;
        while(true){
            if(readIdx >= vAry.length)break;
            TreeNode node = bfsQueue.pollFirst();
            if(vAry[readIdx]!=null){
                node.left = new TreeNode(vAry[readIdx]);
                bfsQueue.addLast(node.left);
            }
            ++readIdx;
            if(readIdx >= vAry.length)break;
            if(vAry[readIdx]!=null){
                node.right = new TreeNode(vAry[readIdx]);
                bfsQueue.addLast(node.right);
            }
            ++readIdx;
        }
        
        return ret;
    }

    public static Integer[] toIntArray(TreeNode treeNode){
        if(treeNode==null){return new Integer[0];}
        LinkedList<Integer> retList = new LinkedList<>();
        LinkedList<TreeNode> bfsQueue = new LinkedList<>();
        
        retList.addLast(treeNode.val);
        bfsQueue.addLast(treeNode);
        
        while(!bfsQueue.isEmpty()){
            TreeNode node = bfsQueue.pollFirst();
            if(node.left!=null){
                retList.addLast(node.left.val);
                bfsQueue.addLast(node.left);
            }else{
                retList.addLast(null);
            }
            if(node.right!=null){
                retList.addLast(node.right.val);
                bfsQueue.addLast(node.right);
            }else{
                retList.addLast(null);
            }
        }
        
        while(true){
            if(retList.isEmpty())break;
            if(retList.getLast()!=null)break;
            retList.pollLast();
        }
        
        return retList.toArray(new Integer[0]);
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
    
    public static void pprint(Integer[] arg){
        int i=0;
        while(true){
            for(int j=0;j<10;++j){
                if(i>=arg.length)return;
                System.out.print((arg[i]==null)?"null":arg[i].toString());
                System.out.print(",");
                ++i;
            }
            System.out.println("");
        }
    }
}
