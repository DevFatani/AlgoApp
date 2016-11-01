package com.algorithmers.android.algoapp

import android.media.Image
import android.util.Log
import com.algorithmers.android.algoapp.model.*
import java.util.*

/**
 * Created by devfatani on 10/23/16.
 */
class FakeData {

    val categories = mutableListOf<Category>()

    init {
        this.categories.addAll(this.fakeCategories())
        this.fakeSubCategories()
    }


    fun fakeSubCategories() {
        val subCategory1 = SubCategory()
        subCategory1.id = 3001
        subCategory1.name = "thread"
        subCategory1.desc = "mange ur application, and get super performance"
        subCategory1.category = this.categories[0]
        this.categories[0].subCategories.add(subCategory1)

        val subCategory2 = SubCategory()
        subCategory2.id = 3002
        subCategory2.name = "css"
        subCategory2.desc = "design ur web site"
        subCategory2.category = this.categories[2]
        this.categories[2].subCategories.add(subCategory2)

        val subCategory3 = SubCategory()
        subCategory3.id = 3003
        subCategory3.name = "firewall"
        subCategory3.desc = "protect your information"
        subCategory3.category = this.categories[1]
        this.categories[2].subCategories.add(subCategory3)


        val subCategory4 = SubCategory()
        subCategory4.id = 3004
        subCategory4.name = "robots"
        subCategory4.desc = "install intelligent sw"
        subCategory4.category = this.categories[3]
        this.categories[3].subCategories.add(subCategory4)


        val subCategory5 = SubCategory()
        subCategory5.id = 3005
        subCategory5.name = "scheme"
        subCategory5.desc = "relationship b/w tables"
        subCategory5.category = this.categories[6]
        this.categories[6].subCategories.add(subCategory5)

        val subCategory6 = SubCategory()
        subCategory6.id = 3006
        subCategory6.name = "design patterns"
        subCategory6.desc = "clean code and reusable"
        subCategory6.category = this.categories[4]


        val subCategory7 = SubCategory()
        subCategory7.id = 3007
        subCategory7.name = "bug"
        subCategory7.desc = "fix ur bugs"
        subCategory7.category = this.categories[4]


        val subCategory8 = SubCategory()
        subCategory8.id = 3008
        subCategory8.name = "swift"
        subCategory8.desc = "new futures"
        subCategory8.category = this.categories[4]


        this.categories[4].subCategories.add(subCategory6)
        this.categories[4].subCategories.add(subCategory7)
        this.categories[4].subCategories.add(subCategory8)

        val subCategory9 = SubCategory()
        subCategory9.id = 3009
        subCategory9.name = "PHP-Compiler"
        subCategory9.desc = "new things to get"
        subCategory9.category = this.categories[0]
        this.categories[0].subCategories.add(subCategory9)

    }

    fun fakeCategories(): List<Category> {
        val category1 = Category()
        category1.id = 101
        category1.name = "Mobile Development"
        category1.desc = "All about Mobile Development"


        val category2 = Category()
        category2.id = 102
        category2.name = "Security"
        category2.desc = "All about Security"

        val category3 = Category()
        category3.id = 103
        category3.name = "WEB"
        category3.desc = "All about WEB"

        val category4 = Category()
        category4.id = 104
        category4.name = "AI"
        category4.desc = "All about AI"

        val category5 = Category()
        category5.id = 105
        category5.name = "Programming"
        category5.desc = "All about Programming"


        val category6 = Category()
        category6.id = 106
        category6.name = "Clean-Code"
        category6.desc = "All about Clean_Code"

        val category7 = Category()
        category7.id = 107
        category7.name = "Database"
        category7.desc = "All about Database"

        val categories = mutableListOf<Category>()
        categories.add(category1)
        categories.add(category2)
        categories.add(category3)
        categories.add(category4)
        categories.add(category5)
        categories.add(category6)
        categories.add(category7)
        return categories
    }

    fun fakeVideoList(): List<Any> {
        val videoList = mutableListOf<Any>()

        val video1 = Video()
        video1.id = 1001
        video1.videoId = "nNZfC20p1T4"
        video1.duration = .0f
        video1.name = "تركيب أجزاء المُحرك معًا"
        video1.txt = "يُعاني حوالي نصف الأشخاص فوق عمر 65 من مشاكل مُتكررة في النوم. كما أنّ عدم الحصول على نوم كافٍ سوف يؤدي إلى عواقب وخيمة. حيث سبق أن سبَّب نقص النوم العديد من الحوادث المأساوية كحوادث الانصهار النووي و اصطدام ناقلات النفط، فضلًا عن حوادث السيارات التي يتسبب بها السائقون الذين لم ينالوا القسط الكافي من النوم. كما أنّ تأثير قلة النوم على الحالة الصحية اليومية يُعتبر الأكثر شيوعًا، فقد رُبِط نقص النوم بالعديد من المشاكل الصحية الجسدية والعقلية كنقص الإدراك والمشاكل القلبية والبدانة وضعف الذاكرة وضعف الجهاز المناعي."
        video1.category = this.categories[2]
        video1.img = "010.com"
        video1.like = 100


        val video2 = Video()
        video2.id = 1002
        video2.videoId = "nNZfC20p1T4"
        video2.duration = .0f
        video2.name = "تركيب أجزاء المُحرك معًا"
        video2.txt = "تتفاوت كمية النوم التي يتطلبها كلُ إنسان، فمُعظم البالغين يحتاجون من 7 إلى 8 ساعات نوم كل ليلة. وبالإضافة إلى كمية النوم، فإنّ نوعية النوم تُعتبر مُهمة أيضًا، حيث أنّ الاستيقاظ المُتكرر أو النوم المُتقطع يُعيق دورة النوم، ويمكن أن يُساهم في عدم قابلية الوصول إلى كل من مرحلتي النوم المُرتبطتين بالنوم المريح والمُجدَّد وهما مرحلة النوم العميق ومرحلة الـ (REM)."
        video2.category = this.categories[1]
        video2.img = "110.com"
        video2.like = 50


        val video3 = Video()
        video3.id = 1003
        video3.videoId = "nNZfC20p1T4"
        video3.duration = .0f
        video3.name = "تركيب أجزاء المُحرك معًا"
        video3.txt = "إنّ البالغين الأكبر سنًا مُعرضون لكمية أكبر من مخاطر نقص النوم بما أنهم يختبرون ساعات نوم أقل ويختلف نموذج دورة النوم لديهم. ونتيجة لذلك، فإنّ مرحلة النوم العميق تُصبح قصيرة جدًا وقد تتوقف نهائيًا. وهناك العديد من العوامل التي تلعب دورًا في ذلك ومنها الشيخوخة وتناول الأدوية وعند وجود إحدى الحالات الطبية التي تُسبب الألم أثناء الليل كالتهاب المفاصل والتبوُّل الليلي المُتكرِّر والسرطان وأمراض الرئة."
        video3.category = this.categories[0]
        video3.like = 88

        videoList.add(video1)
        videoList.add(video2)
        videoList.add(video3)
        return videoList
    }

    fun fakeTxtList(): List<Any> {
        val txtList = mutableListOf<Any>()
        val txt1 = Txt()
        txt1.id = 1
        txt1.name = "المبدأ الأساسي لأي محرك احتراق داخلي"
        txt1.desc = "this is txt 1"
        txt1.img = "12.com"
        txt1.like = 20
        txt1.category = this.categories[3]
        txt1.txt = "إنّ النوم جيدًا يبدو أصعب عندما نُحاول أن نحصل عليه! حيث أنّ الحياة المُعاصرة تعني أننا أصبحنا نملك المزيد والمزيد من “سارقي النوم” أكثر من أي وقتٍ مضى! إذ أصبح بإمكاننا العمل والتسوق وإدارة أمورنا المالية على مدى 24 ساعة في اليوم ونحن جالسون في غُرفة المعيشة!"

        val txt2 = Txt()
        txt2.id = 2
        txt2.name = "المبدأ الأساسي لأي محرك احتراق داخلي"
        txt2.desc = "this is txt 2"
        txt2.img = "13.com"
        txt2.like = 190
        txt2.category = this.categories[5]
        txt2.txt = "إنّ حصولنا على نومٍ جيد يُعتبر أصعب عندما نتقدم في السن! حيث يغدو نومنا خفيفًا ولساعاتٍ أقل، على الرغم من أنّ حاجتنا للنوم لا تتغير. وعلى عكس ما يدَّعيه بعض الأشخاص المحرومين من النوم، فمن المُستحيل أن تُدرِّب جسمك على النوم القليل."


        val txt3 = Txt()
        txt3.id = 3
        txt3.name = "المبدأ الأساسي لأي محرك احتراق داخلي"
        txt3.desc = "this is txt 3"
        txt3.img = "14.com"
        txt3.like = 1022
        txt3.category = this.categories[4]
        txt3.txt = "وتُعتبر تأثيرات قلة النوم تراكُمية. وكنتيجةٍ لذلك، ستنمو حالة نقص النوم عندك في كل ليلةٍ لا تنال فيها كميًة كافيًة من النوم. وبعد مُضي عدة ليالي مصحوبة بنقص النوم – حتى وإن كان مقدار النقص عبارة عن ساعة أو ساعتين في كل ليلة – سيُصبح أداؤك كما لو لم تنمْ إطلاقًا لمدة يومٍ أو يومين. وإذا فقدت ساعتين من ساعات النوم في كل ليلة، فبعد أسبوعٍ فقط سيتراكم لديك دَينٌ بمقدار 14 ساعة نوم. وإذا لم تحصل على قسطٍ كافٍ من النوم بشكلٍ متكرر، فلن تتمكن من وفاء دَينِك المُتمثل بساعات النوم الناقصة بواسطة نومك في عطل نهاية الأسبوع."


        txtList.add(txt1)
        txtList.add(txt2)
        txtList.add(txt3)
        return txtList
    }

    fun fakeAudioList(): List<Any> {
        val videoList = mutableListOf<Any>()

        val audio1 = Audio()
        audio1.id = 4001
        audio1.name = "تركيب أجزاء المُحرك معًا"
        audio1.txt = "يُعاني حوالي نصف الأشخاص فوق عمر 65 من مشاكل مُتكررة في النوم. كما أنّ عدم الحصول على نوم كافٍ سوف يؤدي إلى عواقب وخيمة. حيث سبق أن سبَّب نقص النوم العديد من الحوادث المأساوية كحوادث الانصهار النووي و اصطدام ناقلات النفط، فضلًا عن حوادث السيارات التي يتسبب بها السائقون الذين لم ينالوا القسط الكافي من النوم. كما أنّ تأثير قلة النوم على الحالة الصحية اليومية يُعتبر الأكثر شيوعًا، فقد رُبِط نقص النوم بالعديد من المشاكل الصحية الجسدية والعقلية كنقص الإدراك والمشاكل القلبية والبدانة وضعف الذاكرة وضعف الجهاز المناعي."
        audio1.category = this.categories[2]
        audio1.img = "010.com"
        audio1.like = 100
        audio1.audioSrc = "http://www.sounddogs.com/previews/25/mp3/483031_SOUNDDOGS__al.mp3"


        val audio2 = Audio()
        audio2.id = 4002
        audio2.name = "تركيب أجزاء المُحرك معًا"
        audio2.txt = "تتفاوت كمية النوم التي يتطلبها كلُ إنسان، فمُعظم البالغين يحتاجون من 7 إلى 8 ساعات نوم كل ليلة. وبالإضافة إلى كمية النوم، فإنّ نوعية النوم تُعتبر مُهمة أيضًا، حيث أنّ الاستيقاظ المُتكرر أو النوم المُتقطع يُعيق دورة النوم، ويمكن أن يُساهم في عدم قابلية الوصول إلى كل من مرحلتي النوم المُرتبطتين بالنوم المريح والمُجدَّد وهما مرحلة النوم العميق ومرحلة الـ (REM)."
        audio2.category = this.categories[1]
        audio2.img = "110.com"
        audio2.like = 50
        audio2.audioSrc = "http://www.sounddogs.com/previews/37/mp3/324366_SOUNDDOGS__tu.mp3"


        val audio3 = Audio()
        audio3.id = 4003
        audio3.name = "تركيب أجزاء المُحرك معًا"
        audio3.txt = "إنّ البالغين الأكبر سنًا مُعرضون لكمية أكبر من مخاطر نقص النوم بما أنهم يختبرون ساعات نوم أقل ويختلف نموذج دورة النوم لديهم. ونتيجة لذلك، فإنّ مرحلة النوم العميق تُصبح قصيرة جدًا وقد تتوقف نهائيًا. وهناك العديد من العوامل التي تلعب دورًا في ذلك ومنها الشيخوخة وتناول الأدوية وعند وجود إحدى الحالات الطبية التي تُسبب الألم أثناء الليل كالتهاب المفاصل والتبوُّل الليلي المُتكرِّر والسرطان وأمراض الرئة."
        audio3.category = this.categories[0]
        audio3.like = 88
        audio3.audioSrc = "http://www.freesound.org/data/previews/137/137227_1735491-lq.mp3"

        videoList.add(audio1)
        videoList.add(audio2)
        videoList.add(audio3)
        return videoList
    }

    fun fakeImgList(): List<Any> {
        val videoList = mutableListOf<Any>()

        val image1 = Image()
        image1.id = 5001
        image1.name = "تركيب أجزاء المُحرك معًا"
        image1.txt = "يُعاني حوالي نصف الأشخاص فوق عمر 65 من مشاكل مُتكررة في النوم. كما أنّ عدم الحصول على نوم كافٍ سوف يؤدي إلى عواقب وخيمة. حيث سبق أن سبَّب نقص النوم العديد من الحوادث المأساوية كحوادث الانصهار النووي و اصطدام ناقلات النفط، فضلًا عن حوادث السيارات التي يتسبب بها السائقون الذين لم ينالوا القسط الكافي من النوم. كما أنّ تأثير قلة النوم على الحالة الصحية اليومية يُعتبر الأكثر شيوعًا، فقد رُبِط نقص النوم بالعديد من المشاكل الصحية الجسدية والعقلية كنقص الإدراك والمشاكل القلبية والبدانة وضعف الذاكرة وضعف الجهاز المناعي."
        image1.category = this.categories[2]
        image1.img = "010.com"
        image1.like = 100
        image1.src = "https://i.ytimg.com/vi/QX4j_zHAlw8/maxresdefault.jpg"


        val image2 = Image()
        image2.id = 5002
        image2.name = "تركيب أجزاء المُحرك معًا"
        image2.txt = "تتفاوت كمية النوم التي يتطلبها كلُ إنسان، فمُعظم البالغين يحتاجون من 7 إلى 8 ساعات نوم كل ليلة. وبالإضافة إلى كمية النوم، فإنّ نوعية النوم تُعتبر مُهمة أيضًا، حيث أنّ الاستيقاظ المُتكرر أو النوم المُتقطع يُعيق دورة النوم، ويمكن أن يُساهم في عدم قابلية الوصول إلى كل من مرحلتي النوم المُرتبطتين بالنوم المريح والمُجدَّد وهما مرحلة النوم العميق ومرحلة الـ (REM)."
        image2.category = this.categories[1]
        image2.img = "110.com"
        image2.like = 50
        image2.src = "http://www.auromere.com/img-books.jpg"


        val image3 = Image()
        image3.id = 5003
        image3.name = "تركيب أجزاء المُحرك معًا"
        image3.txt = "إنّ البالغين الأكبر سنًا مُعرضون لكمية أكبر من مخاطر نقص النوم بما أنهم يختبرون ساعات نوم أقل ويختلف نموذج دورة النوم لديهم. ونتيجة لذلك، فإنّ مرحلة النوم العميق تُصبح قصيرة جدًا وقد تتوقف نهائيًا. وهناك العديد من العوامل التي تلعب دورًا في ذلك ومنها الشيخوخة وتناول الأدوية وعند وجود إحدى الحالات الطبية التي تُسبب الألم أثناء الليل كالتهاب المفاصل والتبوُّل الليلي المُتكرِّر والسرطان وأمراض الرئة."
        image3.category = this.categories[0]
        image3.like = 88
        image3.src = "http://www.telegraph.co.uk/content/dam/motoring2/2015/12/01/mercedes-amg-gt-front-xlarge-xlarge_trans++rWYeUU_H0zBKyvljOo6zlkYMapKPjdhyLnv9ax6_too.jpg"

        videoList.add(image1)
        videoList.add(image2)
        videoList.add(image3)
        return videoList
    }

    fun fakeAd(): List<Any> {
        val ad1 = Ad()
        ad1.id = 901
        ad1.name = "إعلان ١"
        ad1.desc = "يوجد شقة للإيجار ٢ حمام ومطبخ وصالة كبيرة"

        val ad2 = Ad()
        ad2.id = 902
        ad2.name = "إعلان ٢"
        ad2.desc = "ونيت نسيان موديل ٩٢ للبيع"

        val ad3 = Ad()
        ad3.id = 903
        ad3.name = "إعلان ٣"
        ad3.desc = "شركة المنظفات لتنظيف المستودعات و المخازن بإحترافية وبأسعار منافسة"
        val videoList = mutableListOf<Any>()

        videoList.add(ad1)
        videoList.add(ad2)
        videoList.add(ad3)
        return videoList
    }

    fun getByCategory(id: Int): List<Any> {
        Log.v("ss1", "id: " + id)
        val multiList = mutableListOf<Any>()
        for (x in this.fakeVideoList()) {
            val video = x as Video
            if (video.category.id == id) {
                multiList.add(video)
            }

        }
        for (x in this.fakeTxtList()) {
            val txt = x as Txt

            if (txt.category.id == id) {
                multiList.add(txt)
            }
        }
        return multiList
    }
}