package database;

import com.vdurmont.emoji.EmojiParser;
import gui.HolderCont;
import instagramimpl.MainHandl;
import model.CometonAccount;
import model.InstagramUserRecord;

import java.util.*;
import java.util.regex.Pattern;

public class Test {

    public static int globalBegin = 165;

    public static void main(String args[]) {

        int choice = 3;
        switch (choice) {
            case 1:
                getMails(28);
                break;

            case 2:
                testDb();
                break;

            case 3:
                runeer();
                break;

            case 4:
                printRandomPositiveWords(222,42);
                break;


        }


        //runeer();
    }


    public static String generateMessageExamples() {
        String positiveWords = "ABLE. ACCEPT – ACCEPTANCE – ACCEPTABLE – ACCEPTED – ACCEPTING. ACTION. ACTIVATE. ACTIVE. ADD. ADDITION. ADORABLE. ADVANTAGE. AFFIRM. AGELESS. AGREE. AGREEABLE. AID. AIM. ABUNDANCE. ACCOUNTABILITY. ACCOMPLISHMENT – ACCOMPLISH. ACCURACY. ACHIEVEMENT – ACHIEVE. ACKNOWLEDGMENT. ADAPTABILITY. ADVENTURE – ADVENTUROUS. AGILITY. ALERTNESS. AMBITION.\n" +
                "\n" +
                "ANTICIPATION.    APPRECIATE – APPRECIATION – APPRECIATIVE – APPRECIATIVENESS.   ASSERTIVENESS – ASSERTIVE.   ATTENTIVENESS.   AUDACITY.   AWARE – AWARENESS.   AUTHENTIC – AUTHENTICITY.   ABRACADABRA.   ATTRACTION.   ALLOW – ALLOWING.   AFFECTION – AFFECTIONATE.   ABSORBED.   ALERT.   AMAZED.   AWE – AWED.   ANIMATE – ANIMATED – ANIMATING – ANIMATION – ANIMATENESS.   ARDENT.   AMAZING.   AWESOME – AWESOMENESS.   AROUSED.   ASTONISHED – ASTONISHING.   AMUSED.   AIR – AIRNESS.   ALOHA.   ADORE.    ADMIRE.   ADMIRABLE.  \n" +
                "\n" +
                "ALLURE.    ANGEL – ANGELIC.    ALTRUISM – ALTRUISTIC.   ABOUND – ABOUNDING – ABOUNDS- ABUNDANT.   ABSOLUTE – ABSOLUTELY.   ACCESSIBLE.   ACCLAIMED.   ACCOMMODATE – ACCOMMODATED – ACCOMMODATION – ACCOMMODATING.    AMPLE.   APPRECIATIVE JOY.   AMIN.   ACCENTUACTIVITY.   ACTABILITY.   AFFABLE.   ALACRITY.   ALTRUCAUSE.   AMIABLE. ASTOUNDING. ATTRACTIVE. ALIVE – ALIVENESS. ACCLAIM.   ABUNDANT GRATIFICATION.   ACCLAMATION.   ACCOMPLISHED.   ACCOMPLISHMENTS.   ACCURATE.   ACCURATELY.   ACHIEVABLE.   ACHIEVEMENTS.   ACTION FOR HAPPINESS.   ACTIVE AND CONSTRUCTIVE STEPS.  \n" +
                "\n" +
                "ACTS OF KINDNESS.   ADAPTABLE.   ADAPTIVE.   ADEQUATE.   ADMIRABLY.   ADMIRATION.   ADMIRED.   ADORED.   ADORING.   ADORINGLY.   ADVANCED.   ADVANTAGEOUS.   ADVANTAGEOUSLY.   ADVANTAGES.   AFFABILITY.   AFFABLY.   AFFINITY.   AFFIRMATION.   AFFIRMATIVE.   AFFLUENCE.   AFFLUENT.   AFFORD.   AFFORDABLE.   AFFORDABLY.   AGILE.   AGILELY.   AGREEABLENESS.   AGREEABLY.   ALIGNED.   ALL IS WELL.   ALLURING.   ALLURINGLY.   ALTERNATIVE HEALING.   ALTRUISTICALLY.   AMAZE.   AMAZEMENT.   AMAZES.   AMAZINGLY.   AMIABILITY.   AMICABILITY.   AMICABLE.   AMICABLY.   AMUSING.   APPEAL.   APPEALING.   APPLAUD.   APPRECIABLE.   APPRECIATED.   APPRECIATES.   APPRECIATION OF BEAUTY.   APPRECIATIVELY.   APPROPRIATE.   APPROVAL.   APPROVE.   ARDOR.   ART OF APPRECIATION.   ART OF STILLNESS.   ART OF WELL-BEING.   ASSURANCE.   A REASON FOR BEING.  \n" +
                "\n" +
                "ACARONAR.   ACCOMMODATIVE.   ALTITUDINARIAN.   AMAZING WORDS.   AMIABLY.   ACCOLADE.   ACUMEN.   ADJUSTABLE.   ADMIRER.   ADMIRING.   ADMIRINGLY.   ADORER.   ADROIT.   ADROITLY.   ADULATED.   ADULATION.   ADULATORY.   ADVENTURESOME.   ADVOCATED.   AMBITIOUS.   AMBITIOUSLY.   AMELIORATE.   AMENITY.   AMITY.   AMPLY.   AMUSE.   AMUSINGLY.   APOTHEOSIS.   ASSUME YOUR OWN VALUE.   ASTONISHINGLY.   ASTONISHMENT.   ATTRIBUTIONAL STYLE QUESTIONNAIRE (ASQ).   AUTHENTIC HAPPINESS.   AWAKEN. AWAKENING. AWE-GASMIC. AKASHIC RECORDS.   AURORA"
                + "BEATIFY.   BEATITUDE.   BENEFICIAL.   BENEFIT.   BENEVOLENT.   BELOVED.   BEST.   BETTER.   BLESS – BLESSING – BLESSED.   BLISS – BLISSFULNESS – BLISSFUL.   BLOOM.   BLOSSOM.   BALANCE – BALANCED.   BEAUTY – BEAUTIFUL – BEAUTIFULLY.   BELONG – BELONGING.   BOLDNESS.   BRAVERY.   BRILLIANCE – BRILLIANT.   BLISS ON TAP.   BEYOND FABULOUS.   BIOPHILIA.   BRIGHT – BRIGHTEN.   BRIGHTNESS.   BALLISTIC.   BLASTING.  \n" +
                "\n" +
                "BLAZING.   BLINDING.   BREATHTAKING.   BUBBLING.   BUSTING.   BLISSCIPLINE.   BUOYANCY. BULLISHNESS.   BRISKNESS.   BUOYANCY.   BREEZINESS.   BRIO.   BE EXTRAORDINARY.   BE HAPPY.   BEAUTIFY.   BEING AT REST.   BENEFACTOR.   BENEFITS.   BENEVOLENCE.   BENEVOLENTLY.  BENEVOLENTLY CHEERFUL STATE OF MIND.   BEST OF ALL POSSIBLE WORLDS.   BEYOND.  \n" +
                "\n" +
                "BEAUTY IN ALL THINGS.   BEINGNESS.   BELIEVABLE.   BLOOD-BROTHERS.   BOHEMIAN SOUL.   BOHO-SOUL. BADASSERY.   BEST-SELLING.   BETTER AND BETTER.   BETTER-KNOWN.   BETTER-THAN-EXPECTED.   BEYOND THANK YOU.   BIG VISION.   BLITHESOME.   BLOSSOMING.   BONUS. BLING BLING. BUDO. BLASTING LOVE.   BUDDHAHOOD" +
                "CARE – CARING.   CALM.   CREATE.   CREATIVE – CREATIVITY – CREATIVENESS.   CAPABLE – CAPABILITY – CAPABLY.   CELEBRATE – CELEBRATION.   CERTAIN – CERTAINTY.   CHARITABLE – CHARITY.   CHARM – CHARMING – CHARMER.   CHOICE.   CLEAN – CLEANLINESS.   COMFORT – COMFORTABLE – COMFORTING.   CUDDLE – CUDDLING.   CANDOR.   CAREFULNESS.   CHALLENGE.  \n" +
                "\n" +
                "CHANGE.   CHEERFUL – CHEERFULNESS.   CLARITY.   COLLABORATION.   COMMITMENT.   COMMUNICATION.   COMMUNITY.   COMPASSION – COMPASSIONATE.   COMPETENT – COMPETENCE – COMPETENCY.   CONCENTRATION.   CONFIDENT – CONFIDENCE.   CONSCIOUSNESS.   CONSISTENCY – CONSISTENT.   CONTENT – CONTENTMENT.   CONTINUITY – CONTINUOUS.   CONTRIBUTION.   CONVICTION – CONVINCING.   COOPERATION.  COURAGE.   COURTESY – COURTEOUS.    CURIOUS – CURIOSITY.   CHAKRA.   COOL.  \n" +
                "\n" +
                "CLEAR HEADED.   CENTERED.   CLOSENESS.   COMPANIONSHIP.   CONSIDERATE – CONSIDERATION.   COMMUNION.   CONNECT – CONNECTED – CONNECTION – CONNECTEDNESS.   CONQUER.   CUTE.   CHARISMA – CHARISMATIC.   COLLECTED.   CHEERFUL WILLINGNESS.   CHEERS.   CONGRUENCE.   CORDIAL.   CRANK (UP). CAPITAL. CORKING.   CLEAR.   CARESS.   CHEERFUL MOOD.   COMPLIMENTARY WORDS.     CONTENTED.   COZINESS.   CUTENESS.  \n" +
                "\n" +
                "CAREFREENESS.   CAREFREE.   CENTERING.   CENTERING MEDITATION.   CITIZEN OF MASTERY.   CO-CREATING.   CO-CREATOR.   COHESION.   CONTINUAL STREAM OF SYNCHRONICITY.   CREATIVE PROCESS. CREATIVE AFFIRMATIONS. COMPOSTURE. CONCORD. CEREBRO. CONSCIOUSNESS ENGINEERING. CHI. CLASSY. COPACABANA.   COSMIC AWARENESS" +
                "DIRECTION.   DELICATE.   DECENT.   DESIRABLE.   DELICIOUS – DELICIOUSNESS.   DO.   DREAM – DREAMY.   DYNAMIC.   DARING.   DECISIVENESS.   DELIGHT – DELIGHTED – DELIGHTFUL.   DEPENDABILITY.   DESIRE.   DETERMINATION.   DEVOTION.   DIGNITY.   DILIGENCE.   DISCIPLINE.   DISCOVERY.  \n" +
                "\n" +
                "DISCRETION.   DIVERSITY.   DRIVE.   DUTY.   DIVINE.   DAZZLED.   DISNEY.   DEVOTED.   DANDY.   DAIMON.   DEBONAIR.   DETACHMENT. DEDICATED.   DAUWTRAPPEN.   DAZZLE.   DELIGHTFULLY.   DEFENCELESSNESS. DEEPER PART OF YOU.   DESERVE.   DESERVEDNESS.   DESERVINGNESS.   DIS-IDENTIFY.   DOPE.   DOPE CHILL OUT" +
                "EMPATHY – EMPATHIZE – EMPHATIC.   EASY – EASILY – EASIER.   EDUCATE – EDUCATION – EDUCATED.   EFFICIENT.   ENABLE – ENABLED.   ENERGETIC – ENERGIZE – ENERGY.   ENGAGE – ENGAGING – ENGAGED.   ENJOY – ENJOYMENT.   ENOUGH.   EAGER – EAGERNESS.   EFFECTIVENESS.   EFFICIENCY.   ELATION.   ELEGANCE.   ENCOURAGE – ENCOURAGEMENT – ENCOURAGED.  \n" +
                "\n" +
                "ENDURANCE.   EQUALITY.   EXCELLENCE – EXCELLENT.   EXCITE – EXCITEMENT – EXCITED.   EXPERIENCE.   EXPERTISE.   EXPLORATION.   EXPRESSIVENESS – EXPRESSING.   ENLIGHTENMENT – ENLIGHTENED.   ETERNAL.   EXALTATION.   EMULATE.   EMPOWER – EMPOWERING – EMPOWERED.   EXPANSIVE.   EXHILARATING.   ENTHUSIASTIC – ENTHUSIASM.   ENGROSSED.   ENCHANTED.   ENTRANCED.   ECSTATIC.   ELATED.   ENTHRALLED.   EXUBERANT – EXUBERANCE.   EXPECTANT.   EQUANIMOUS.   ENLIVENED.   EFFICACY. \n" +
                "\n" +
                "EASE.   EXEMPLARY.   EXTRAORDINARY.   EARNEST.   ELEVATE – ELEVATED.   EQUANIMITY.   EASE-OF-MIND.   EXCITED ANTICIPATION.   EXTRA.   EQUITY – EQUITABLY – EQUITABLE.   EASY TO TALK TO.   EASY TO APPROACH.   ECSTATIFY.     EUDAEMONISM.   EUDAEMONIST.   EUDAEMONISTIC.   EUDAIMONIA.   EUDAMONIA.   EVOLVE.   EXALTING.   EXSTATISFY.   EXULTANT. ASTRONOMICAL. CHAMPION. CHAMP’. ELECTRIC. ENORMOUS. EXCEPTIONAL.\n" +
                "\n" +
                "EXCITING. EXQUISITE.   EFFORTLESSNESS. EUNOIA.  ECOSOPHY. EBULLIENCE.  EMBRACE.   EMPOWERING WORDS.   ENCOURAGING WORDS.   ERLEBNIS.   EFFORTLESS EASE.   EFFORTLESSLY.   EKAGGATA.   EMBODY THE LOVE. EARTHING. EVER-JOYOUS. EVER-JOYOUS NOW.   ETHEREAL.   ENDLESS.   E MA HO"+
                "Positive Words starting with letter F\n" +
                "FANTASTIC.   FEEL GOOD – FEELING GOOD.   FLOW – FLOWING.   FABULOUS.   FAIR.   FAITH.   FAITHFUL.   FAME.   FAVORITE.   FAIRNESS.   FAMILY.   FIDELITY.   FLEXIBILITY.   FOCUS.   FLOURISH.   FORGIVE – FORGIVING – FORGIVENESS.   FORTITUDE.   FREE – FREEDOM.     FRUGALITY.   FUN.   FUTURE.   FRIEND – FRIENDLY – FRIENDSHIP – FRIENDLINESS.   FASCINATE – FASCINATED.  \n" +
                "\n" +
                "FULFILL – FULFILLED.   FOOD.   FEISTY – FEISTINESS.   FEASIBLE.   FINE.   FEARLESS.  FESTIVE – FESTIVENESS.   FIT.   FANTABULOUS. FREECYCLE.   FUNERIFIC.   FUNOLOGY.   FLAWLESS.   FAMOUS.   FANCY.   FLASHY.   FTW.   FUNNY JOKES. FLAUNTING.   FONDLE.  FRIC-TIONLESSLY.   FLAWLESSLY.    FLOURISHING.   FORTUITOUS. FUN-LOVING. FREE-SPIRITED. FELICITY\n" +
                "\n" +
                "Positive Words starting with letter G\n" +
                "GLOW.  GENEROUS – GENEROSITY.   GENERATE.   GENIAL.   GENIUS.   GENUINE.   GIFT.   GIVE – GIVING.   GOOD.   GOODNESS.   GOING THE EXTRA MILE.   GRACE.   GRATITUDE – GRATEFULNESS.   GROW – GROWTH.   GUIDE – GUIDING – GUIDANCE.   GOD.   GROUNDED.   GLORY.   GODLINESS.   GOOD-FEELING.   GROOVY.   GIDDY.   GLAD.   GOOD HEALTH.   GLAMOR.   GIGGLING.  \n" +
                "\n" +
                "GODDESS.   GORGEOUS – GORGEOUSNESS.   GRANDIOSITY. GENERAVITY. GENTLEMAN. GARGANTUAN. GRAND. GREAT. GINGER.   GOOD-HUMORED.   GOODWILL.   GREATFUL.  GEMUTLICHKEIT.   GIBIGIANA.   GIGIL.   GOOD INDWELLING SPIRIT.   GOOD WORD.   GOOD WORDS.   GOOD-HUMORED.   GOODWILL.   GOOD FORTUNE.    GYPSY SOUL.   GAME-CHANGER.   GENERATOR OF LIFE.   GRACEFULLY.   GRACIOUSNESS.   GOLDILOCKS.   GENUINENESS.   GREAT ZEAL.   GOOD DONE IN SECRET\n" +
                "\n" +
                "Positive Words starting with letter H\n" +
                "HOPE – HOPEFULNESS.   HAPPINESS – HAPPY – HAPPILY.   HARMONIOUS – HARMONIZE – HARMONY.   HEALTH – HEALTHY.   HEART.   HELLO.   HELP – HELPFUL – HELPING.   HOT – HONEST – HONESTY.   HUMAN.   HUMOR.   HELPFULNESS.   HERO – HEROISM.   HOLY – HOLINESS.   HONOR.   HOSPITALITY.   HUMBLE.  HEAVEN – HEAVENLY.   HALO.   HEARTFELT.   HEARTWARMING.   ONE-POINTEDNESS.   HAPPY HEARTED. HEEDFUL. HANDSOME. HUGE.\n" +
                "\n" +
                "HIGH-SPIRITEDNESS. HIGHLY DISTINGUISHED. HAPPY WORDS. HEART-OPENING. HOSPITABLE. HUMAN FLOURISHING. HIGHLY DISTINGUISHED. HARNESS. HEIGHTENED. HOLISTIC. HOLY SPIRIT. HALL OF AWESOMENESS. HONEY BADGER. HIGHER CONSCIOUSNESS. HALCYON. HABITUATION. HAKUNA MATATA\n" +
                "\n" +
                "Positive Words starting with letter I\n" +
                "IMAGINATION.   INSPIRE – INSPIRATION – INSPIRED – INSPIRATIONAL.   IN-LOVE.   IDEA.   INCREDIBLE.   INNOVATE – INNOVATION.   INTERESTING – INTEREST – INTERESTED.   IMPROVEMENT.   INDEPENDENCE.   INFLUENCE.   INGENUITY.   INNER PEACE.   INSIGHT – INSIGHTFULNESS – INSIGHTFUL.   INTEGRITY.   INTELLIGENCE – INTELLIGENT.   INTENSITY.   INTIMACY.   INTUITIVENESS.   INVENTIVENESS.   INVESTING.   INTENTION.   INVIGORATE – INVIGORATED.   INTRIGUED. \n" +
                "\n" +
                "INVOLVE – INVOLVED.   INCLUSION.   INNOCENT.   INEFFABLE – INEFFABILITY.   INTREPID. IDEALISM. ILLUMINATION – ILLUMINATED. INCOMPARABLE. INVINCIBLE.   INQUISITIVE.   INFINITE.   INFINITY.   ILLUSTRIOUS.   INNER.   ICHARIBA CHODE.   IKIGAI.   INCREDIBLE CUTENESS.   INDWELLING.   INSPIRATIONAL WORDS.   INSPIRING WORD.   INSPIRING WORDS.   IRIDESCENT. ILLUSTRIOUS.   INNER.   INNER SPIRIT.   INTERCONNECTED.   INTERCONNECTIVITY.   INTUITION.  INCLUSIVENESS\n" +
                "\n" +
                "Positive Words starting with letter J\n" +
                "JOY – JOYFUL – JOYOUS. JOKE. JOLLY. JOVIAL. JUST. JUSTICE. JUBILANT. JUVENESCENT. JUMPY. JAMMIN’. JUBILINGO\n" +
                "\n" +
                "Positive Words starting with letter K\n" +
                "KINDNESS – KIND – KIND-HEART – KINDLY. KEEP-UP. KISS. KNOWLEDGE. KITTENS. KEEN. KAAJHUAB. KALON. KILIG. KIND WORDS. KOIBITO KIBUN. KI. KALEIDOSCOPES OF BUTTERFLIES\n" +
                "\n" +
                "Positive Words starting with letter L\n" +
                "LIKE. LAUGH – LAUGHING. LEARN – LEARNING. LIFE. LIVE – LIVING. LUXURY. LONGEVITY. LOYALTY – LOYAL. LOVE – LOVABLE – LOVING. LIBERTY. LOGIC. LEADER – LEADERSHIP. LUCK – LUCKY. LIGHT. LOVING-KINDNESS. LIVELY. LIFE OF THE PARTY. LOVELY. LOVING ACCEPTANCE. LOVING FEELINGS. LIGHTWORKER. LEADING. LIGHT FOG. LIVES THROUGH. LOVE WORDS. LOVER OF BEAUTY. LUSTROUS. LUSTROUS COLORS. LIGHT-HEARTED. LEEWAY. LET GO. LETTING GO. LIVELINESS. LOVE FULFILLED. LOVING ATTENTION\n" +
                "\n" +
                "Positive Words starting with letter M\n" +
                "MEANING – MEANINGFUL. MORE. MAGNIFICENT. MAJESTY. MANY. MARVELOUS. MERIT. MOTIVATE. MIRACLE. MAGIC. MAKING A DIFFERENCE. MASTERY. MATURITY. MINDFUL – MINDFULNESS. MODESTY. MOTIVATION – MOTIVATIONAL. MERCY. MEDITATION. MIND-BLOWING. MELLOW. MOVED. MOVEMENT. MUTUALITY. MOURNING. MELIORISM. MENCH. MINDSIGHT. MINDSIGHT. MAJOR. MILD. MEANINGFUL WORDS. MEMORABLE. MORPHING. MOTIVATED WORDS. MOTIVATING WORDS. MOTIVATIONAL WORDS. MOVING. MAGNETIC TO LOVE. MIRTHFUL. MYRIAD. MOJO\n" +
                "\n" +
                "Positive Words starting with letter N\n" +
                "NOBLE. NURTURING – NURTURE. NON-RESISTANCE – NON-RESISTANT. NEW. NICE. NIRVANA. NEAT. NATURE-MADE. NOURISH – NOURISHED – NOURISHING – NOURISHMENT. NAMASTE. NEOTENY. NICE WORDS. NOVATURIENT. NON-DUALITY\n" +
                "\n" +
                "Positive Words starting with letter O\n" +
                "OPTIMIST – OPTIMISTIC. OUTSTANDING. OK. ON. ONWARDS. OPEN – OPENLY – OPENING. OPEN-MINDED. OPPORTUNITY. ORIGINAL. OPENNESS. OPTIMISM. ORDER. ORGANIZATION. ORIGINALITY. OUTCOME. ORIENTATION. OBEDIENT. OPEN HEARTED. OMG. OVERCOME. OM MANI PADME HUM. OUTGOING. ONENESS. OUTERNATIONALIST. OVERLY OPTIMISTIC. ORENDA. OWNING YOUR POWER. ONEUP. OMNISCIENCE. OKAGE SAMA\n" +
                "\n" +
                "Positive Words starting with letter P\n" +
                "PERFECT – PERFECTION.   POSITIVE ENERGY.   POSITIVE THOUGHTS.   POSITIVE EVENTS.   POSITIVE CIRCUMSTANCES.   POSITIVE BELIEFS.   PEACE – PACIFY.   PARADISE – PARADISIAC.   PASSION – PASSIONATE.   PLEASE.   PURE.   PERCEPTIVENESS.   PERSEVERANCE.   PERSISTENCE.   PERSONAL GROWTH.   PLEASURE.   POSITIVE ATTITUDE.   POSITIVE WORDS.   POWER – POWERFUL.  \n" +
                "\n" +
                "PRACTICALITY.   PRECISION.   PREPAREDNESS.   PRESENCE.   PRESERVATION.   PRIVACY.   PROACTIVITY – PROACTIVE.   PROGRESS.   PROSPERITY PROSPEROUS.    PUNCTUALITY – PUNCTUAL.   PATIENCE.   PROUD.   PLEASED.   PLAY – PLAYFUL – PLAYFULNESS.   PARTICIPATION.   PURPOSE.   PICK-ME-UP.   PRONIA.   PIOUS.   PUPPIES.   POLITE.   POSITIVE MIND.   POSITIVE THINKING.    PRETTY.   PRECIOUS. PARDON. PERKINESS. PIQUANCY.  POSICHOICE. POSIDRIVING. POSIFIT. POSILENZ. POSIMASS. POSIMINDER. POSIRATIO. POSIRIPPLE. POSIRIPPLER. POSIRIPPLES. POSISINGER. POSISITE.\n" +
                "\n" +
                "POSISTRENGTH. POSITIBILITARIAN. POSITRACTION. POSITUDE. POSIVALUES. POSIWORD. POSSIBILITARIAN. PROMPTNESS. PROTO. PRICELESS. PEP – PEPPINESS.   PERMALICIOUS.   PLUCKY.   POLLYANNAISM.   PRIDE.   POSITIVE FEELINGS.  PEACE OF MIND.   PEACEFUL WORDS.   PETRICHOR.   PHILOCALIST.   POSITIVE EMOTIONS.   POSITIVE FEELINGS.   POSITIVE VOCABULARY.   POWER WORDS.   POWERFUL POSITIVE WORDS.   POWERFUL WORDS.   POWER-ON.   POWER-UP.   PROTECT.    POLITENESS.   POUR YOUR LOVE.   POWERFUL POSSIBILITY.   PRIVILEGE.   PROPITIOUS. POSITIVE THESAURUS. POSITIVE ADJECTIVES. PICTURESQUE. PRANA.   PANACHE\n" +
                "\n" +
                "Positive Words starting with letter Q\n" +
                "QUALITY. QUIET – QUIETNESS. QUAINT. QUIESCENT. QUEENLY. QUICKENING. QUIDDITY. QUIESCENT MIND. QUALITY WORDS. QUANTUMNESS. QUANTUM CONSCIOUSNESS\n" +
                "\n" +
                "Positive Words starting with letter R\n" +
                "RESPECT. RADIANT. READY – READINESS. REAL – REALITY. REASON. RECOMMEND. REFRESH – REFRESHED. RELAX – RELAXED. RELIEF. RELIEVE – RELIEVED. REMARKABLE. RATIONALITY. RECOGNITION. RELATIONSHIPS. RELIABLE – RELIABILITY. RELIGION. RESOURCEFULNESS. RESPONSIBILITY. RIGHTEOUSNESS. RISK-TAKING. ROMANCE. REVELATION. REVIVED. RESTORE – RESTORED. REST – RESTED. RENEW – RENEWED. REJUVENATE – REJUVENATED. RAPTURE – RAPTUROUS. RESILIENT – RESILIENCE. REVERENCE. RIPE. REBORN. RELATEDNESS. RASASVADA. REPOSE. ROSINESS. RELENT. RENOWNED. RESPECTED. RAINBOW. ROMANTIC. RELENT. RENOWNED. RADIATE. RECOGNIZE. RELEASING. RIGHTFUL. ROCKSTAR\n" +
                "\n" +
                "Positive Words starting with letter S\n" +
                "SCOPE.   SMILE – SMILING.   SOULMATE.   SOUL – SOULFUL.   SACRED.   SAFE – SAFETY.   SECURE – SECURED – SECURITY.   SUSTAIN – SUSTAINED.   SAVE. SAVINGS.   SIMPLE – SIMPLIFY.    SELFLESSNESS.   SELF-ESTEEM.   SERVICE.   SIMPLICITY.   SINCERITY.   SKILL – SKILLED.   SPIRIT.   SERENE – SERENITY.   STABILITY.   STRENGTH.   STYLE.   SYSTEMATIZATION.   SELF-LOVE.   STRIVE.   SALVATION.   SELF-RESPECT.   SELF-FORGIVENESS.   SERVE.   SYMPATHETIC.   SELF-COMPASSION.   SELF-KINDNESS.  \n" +
                "\n" +
                "SPELLBOUND.   STIMULATED – STIMULATING – STIMULATION.  SATISFIED.   STILL.   SURPRISED.   SLEEP.   SEXUAL EXPRESSION.   SHELTER.   SELF-EXPRESSION.   SPACE – SPACIOUS. SPONTANEITY – SPONTANEOUS. SUNSHINE. SPARK – SPARKLE – SPARKLES.   SWEET – SWEETNESS.    SUPPORT – SUPPORTING – SUPPORTED.   SEXY – SEXINESS.   SUPREME.   SUCCULENT.   SWEETHEART.   STUDY – STUDIOUS.   SAVOUR – SAVOURING.  \n" +
                "\n" +
                "SUFFICIENT. STUPENDOUS. SWAG – SWAGGY. SPLENDID. SMART. SPECTACULAR. SPECIAL. SERENDIPITY. SYNERGY. SHINE – SHINING. START. STEADFASTNESS. SUBLIME. SUNNINESS. SUPERPOWER. SPUNKY. SHAPE-SHIFTING VIRTUOSO. SOUL-STRETCHING. STRONG WORDS. SACRED SPACE. SHIFT IN FOCUS. SHOW UP MORE PRESENT. STELLAR. SUPERCHARGE. SUPERCHARGED. SYMPTOMS OF GREATNESS. SYNCHRONICITY. SASSY. SUPERCALIFRAGILISTIC. SUPERCALIFRAGILISTICEXPIALIDOCIOUS. SLAYING YOUR DRAGON\n" +
                "\n" +
                "Positive Words starting with letter T\n" +
                "TRUE. TRUST – TRUSTING. TACT. TEACH – TEACHABLE. TEAM. THANKFUL – THANK – THANK-YOU – THANKFULNESS. THERAPY. TIME. TEAMWORK. TIMELINESS. TOLERANCE. TRADITION. TRANQUIL – TRANQUILITY. TRUTH – TRUTHFULNESS. TENDER. THRILLED. TOUCH – TOUCHED. TICKLED. TO MATTER. TO KNOW. TO BE KNOWN. TO BE SEEN. TRANSFORMATIVE – TRANSFORMATION – TRANSFORM. TRIUMPH. THRIVE – THRIVING. TENACITY. TO BE. TRANSPARENT. TEMUL. TENDERLY. TIDSOPTIMIST. TIME OPTIMIST. TO LET GO. THE GREAT SPIRIT\n" +
                "\n" +
                "Positive Words starting with letter U\n" +
                "UNIFICATION. UNIQUE. UPLIFT. ULTIMATE. UNCONDITIONAL. UPGRADE. USEFUL. USER-FRIENDLY. UNITY. UNDERSTAND – UNDERSTANDING – UNDERSTOOD. UNIFICATION OF MIND. UP. UPSKILL. UNBELIEVABLE. UNFLAPPABLE. UNREAL. UTTER AMAZEMENT. UNABASHED. UNABASHED PLEASURE. UNBEARABLY CUTE. UNHURRY. UNBELIEVABLE. UNFLAPPABLE. UNREAL. UTTER AMAZEMENT. UP-LEVELED\n" +
                "\n" +
                "Positive Words starting with letter V\n" +
                "VITALITY. VALUE – VALUES – VALUABLE. VIRTUOUS. VALID. VERIFY. VERY. VIABLE. VIRTUE. VICTORY – VICTORIOUS. VARIETY. VULNERABILITY – VULNERABLE. VIBRANT. VOW. VIM. VIGOR. VENERATION. VOCABULEVERAGE. VERSATILITY. UBUNTU\n" +
                "\n" +
                "Positive Words starting with letter W\n" +
                "WORTH – WORTHY – WORTHINESS. WEALTH. WARM – WARMTH. WELCOME. WILL- WILLING – WILLINGNESS. WISDOM. WISE. WON. WONDERFUL. WELL-BEING. WHOLEHEARTEDNESS. WOW. WONDER. WATER. WELL. WELLNESS. WELFARE. WHOLE. WONDER-WORKING. WIN – WINNABLE – WINNING. WALWALUN. WEB OF RELATEDNESS. WHOLEHEARTEDLY. WILLING TO LEARN. WONDROUS. WORLD-BUILDER. WORTHINESS TO TAKE UP SPACE. WANDERLUST\n" +
                "\n" +
                "Positive Words starting with letter X\n" +
                "XO. X-RAY VISION. XENODOCHIAL. XFACTOR. XENOPHILE. XENIAL\n" +
                "\n" +
                "Positive Words starting with letter Y\n" +
                "YES. YOUTH – YOUTHFUL. YOUNG. YOUNG- AT-HEART. YIPPEE. YAY. YEARN. YEA. YEAH. YUMMY. YEN. YESABILITY. YUGEN. YARAANA. YESABLE. YOU ARE LOVED. YOUR TRUE VALUE\n" +
                "\n" +
                "Positive Words starting with letter Z\n" +
                "ZEALOUS. ZEAL. ZEST – ZESTY – ZESTFUL. ZIPPY. ZING. ZAPPY. ZANY. ZEST FOR LIFE. ZAJEBISCIE"
                ;
        return positiveWords;
    }

    public static void printRandomPositiveWords(int nrOfRows, int nr) {
        String positiveWords = generateMessageExamples();
        String splitted[] = positiveWords.split(" ");
        List<String> wordsList = Arrays.asList(splitted);


        for(int i=0; i<nrOfRows; i++) {
            String toPrint = getWords(wordsList, nr);
            System.out.println(toPrint + "\n");
        }


    }

    private static String getWords(List<String> list, int nrOfWords) {
        Random r = new Random();
        String toReturn = "";
        for(int i=0; i<nrOfWords; i++) {
            int index = r.nextInt()%list.size();
            if(index < 0) index *= -1;
            toReturn = toReturn + " " +list.get(index);
        }
        toReturn = toReturn.replace("." ,"");
        toReturn = toReturn.replace("–" ,"");
        toReturn = toReturn.replace("\n" ,"");
        toReturn = toReturn.toUpperCase();
        toReturn = toReturn.replace("    " ," ");
        toReturn = toReturn.replace("  " ," ");
        toReturn = toReturn.replace("   " ," ");
        toReturn = toReturn.replace("   " ," ");
        return toReturn;
    }

    private static String scramble(String token) {
        String toReturn = "";
        String firstChar = String.valueOf(token.charAt(0));
        String lastChar = String.valueOf(token.charAt(token.length()-1));

        ArrayList<String> coreTokenList = new ArrayList<>();
        String coreToken = token.substring(1, token.length()-1);
        for(char c: coreToken.toCharArray()) {
            coreTokenList.add(String.valueOf(c));
        }

        Collections.shuffle(coreTokenList);

        String coreTokenStr = "";
        for(String s: coreTokenList) {
            coreTokenStr = coreTokenStr + s;
        }

        toReturn = firstChar + coreTokenStr + lastChar;
        return toReturn;
    }

    public static void testDb() {
        DatabaseHandler handler = new DatabaseHandler();
        HolderCont.userName = "username1";
        handler.updateNrOfQueriesLeft(3912L);
    }

    public static void getMails(int nr) {
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> records = handler.getAllRecords();

        ArrayList<String> allMails = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        int counter = 0;


        for(InstagramUserRecord rec: records) {
            String currMail = getMailFromBio(rec.getBio());
            if(currMail != null) {
                counter++;
                buffer.append(currMail + ",");
                if(counter >= nr) {
                    System.out.println(buffer.toString() + "\n");
                    buffer = new StringBuffer();
                    counter=0;
                }
            }
        }

    }

    private static String getMailFromBio(String bio) {
        Scanner scanner = new Scanner(bio);

        String currToken = "";
        while(scanner.hasNext()) {
            currToken = scanner.next();
            if( currToken.contains("gmail") || currToken.contains("yahoo") || currToken.contains("outlook")) {
                currToken = currToken.replace(String.valueOf('"'), "");
                currToken = currToken.replace(String.valueOf(']'), "");
                currToken = currToken.replace(String.valueOf('|'), "");
                currToken = currToken.replace(String.valueOf('/'), "");
                currToken = removeEmoticos(currToken);


                if(currToken.contains(":")) {
                    return currToken.split(":")[1];
                }
                if(currToken.length() > 55) return null;
                String splitted[] = currToken.split("\\.");
                String toReturn =  splitted[0] + ".com";

                if((toReturn.contains("gmail") || currToken.contains("yahoo") || currToken.contains("outlook")) && isValidEmail(currToken)) {
                    return toReturn;
                }
            }
        }
        return null;
    }

    private static boolean isValidEmail(String currToken) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (currToken == null)
            return false;
        return pat.matcher(currToken).matches();
    }

    private static String removeEmoticos(String currToken) {
        currToken = EmojiParser.removeAllEmojis(currToken);

        String characterFilter = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";
        currToken = currToken.replaceAll(characterFilter,"");

        currToken = currToken.replace("ud83","");
        currToken = currToken.replace("dudc","");
        currToken = currToken.replace("uddf","");
        currToken = currToken.replace("u2709","");
        currToken = currToken.replace("u25","");
        currToken = currToken.replace("ufe0","");

        return currToken;
    }

    public static void runeer() {
        while(true) {
            MainHandl handl = new MainHandl();
            handl.start();
            sleepT(95000);
            handl.stop();
            globalBegin++;
        }
    }

    public static void databaseTesting() {
        DatabaseHandler handler = new DatabaseHandler();
        CometonAccount account = handler.getCometonAccount("jimbo", "123456");
    }

    public static void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}











































