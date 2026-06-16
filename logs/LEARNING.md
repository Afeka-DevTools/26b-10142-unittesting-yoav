🧑‍💻:
> תלמד אותי על בדיקות יחידה

🤖:
> **בדיקות יחידה (Unit Testing)** הן נדבך קריטי בפיתוח תוכנה מודרני. הרעיון הבסיסי הוא לקחת את החלק הקטן ביותר שניתן לבדוק ביישום – בדרך כלל פונקציה או מתודה בודדת – ולבדוק אותו בבידוד מוחלט משאר המערכת כדי לוודא שהוא פועל בדיוק כפי שמצופה ממנו.

    ### למה אנחנו צריכים בדיקות יחידה?

    * **איתור באגים מוקדם:** ככל שמוצאים באג קרוב יותר לזמן כתיבת הקוד, כך קל וזול יותר לתקן אותו.
    * **ביטחון בביצוע שינויים (Refactoring):** כשקיימת רשת ביטחון של בדיקות שמכסה את הקוד, אפשר לשנות ולשפר את מבנה הקוד (למשל, לייעל אלגוריתם רקורסיבי מורכב) מבלי לפחד ששברנו פונקציונליות קיימת.
    * **תיעוד חי:** בדיקות יחידה טובות מדגימות בפועל כיצד הפונקציה אמורה להתנהג במקרי קצה שונים, ומשמשות כסוג של הוראות שימוש למפתחים אחרים.

    ---

    ### מבנה קלאסי של בדיקת יחידה: מודל ה-AAA

    בדיקת יחידה טובה נכתבת לרוב לפי תבנית של שלושה שלבים (AAA):

    1. **Arrange (הכנה):** אתחול האובייקטים, הגדרת המשתנים, ויצירת התנאים הדרושים לביצוע הבדיקה.
    2. **Act (פעולה):** קריאה לפונקציה או למתודה שאותה אנו רוצים לבדוק, תוך שימוש בנתונים שהכנו.
    3. **Assert (אימות):** בדיקה האם התוצאה שהתקבלה מהפעולה תואמת לתוצאה לה ציפינו.

    ---

    ### דוגמה מעשית ב-C#

    נניח שיש לנו מחלקה שאחראית על חישובים מתמטיים פשוטים או וולידציה של נתונים. הנה פונקציה פשוטה שבודקת האם מספר הוא זוגי:

    ```csharp
    public class NumberValidator
    {
        public bool IsEven(int number)
        {
            return number % 2 == 0;
        }
    }

    ```

    כך תיראה בדיקת היחידה (בעזרת ספריות כמו NUnit, xUnit או MSTest):

    ```csharp
    [TestClass]
    public class NumberValidatorTests
    {
        [TestMethod]
        public void IsEven_PassingEvenNumber_ReturnsTrue()
        {
            // Arrange
            var validator = new NumberValidator();
            int evenNumber = 4;

            // Act
            bool result = validator.IsEven(evenNumber);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void IsEven_PassingOddNumber_ReturnsFalse()
        {
            // Arrange
            var validator = new NumberValidator();
            int oddNumber = 7;

            // Act
            bool result = validator.IsEven(oddNumber);

            // Assert
            Assert.IsFalse(result);
        }
    }

    ```

    ---

    ### עקרונות לבדיקות יחידה מנצחות

    כדי שהבדיקות באמת יעזרו ולא יהפכו לנטל תחזוקתי, נהוג לעקוב אחר עקרונות **F.I.R.S.T**:

    * **Fast (מהירות):** הבדיקות צריכות לרוץ באלפיות שנייה. אם הן איטיות, המפתחים יפסיקו להריץ אותן.
    * **Isolated (מבודדות):** פונקציה צריכה להיבדק לבד. היא לא אמורה לפנות למסד נתונים, לקרוא קבצים מהדיסק או לפנות לשרת אינטרנט. (כדי לעשות זאת משתמשים בטכניקות כמו **Mocks** ו-**Stubs** שמזייפות את רכיבי החוץ).
    * **Repeatable (ניתנות לחזרה):** הבדיקה חייבת לתת את אותה תוצאה (עוברת או נכשלת) בכל פעם שמריצים אותה, ללא תלות בסביבה או בזמן ההרצה.
    * **Self-Validating (מוודאות את עצמן):** התוצאה של הבדיקה צריכה להיות בינארית – עוברת או נכשלת. המפתח לא אמור להסתכל על פלט בקונסול כדי להבין אם הבדיקה הצליחה.
    * **Timely (מתוזמנות היטב):** מומלץ לכתוב את הבדיקות בסמוך לכתיבת הקוד (או אפילו לפניו, בשיטת TDD - Test Driven Development).

    האם תרצה שאדגים כיצד לכתוב בדיקות יחידה לתרחיש מורכב יותר, כמו למשל פונקציה רקורסיבית, או וולידציה של מבני נתונים כמו מטריצות?

🧑‍💻:
> אני משתמש בgradle לunit testing בjava, אני רוצה פרומפט לתת ל copilot בשביל שהוא יעשה את זה 

🤖:
   > כדי להוציא את המקסימום מ-Copilot (או כל כלי AI אחר) לכתיבת בדיקות בסביבת Java עם Gradle, הסוד הוא לספק הנחיות ברורות שדורשות לא רק בדיקה של "נתיב הזהב" (Happy Path), אלא גם כיסוי מקיף של מקרי קצה, ולידציה קפדנית של הלוגיקה האלגוריתמית, ושימוש נכון בתבניות עבודה.

    מכיוון ש-Copilot עובד בצורה המדויקת ביותר עם אנגלית טכנית, הכנתי עבורך תבנית פרומפט באנגלית שתוכל להעתיק ולהדביק.

    ### תבנית הפרומפט ל-Copilot

    העתק את הטקסט הבא והוסף בסופו את הקוד שאתה רוצה לבדוק:

    > "Please write comprehensive JUnit 5 unit tests for the following Java class.
    > **Requirements:**
    > 1. **Frameworks:** Use JUnit 5 (Jupiter) for testing and Mockito for mocking any external dependencies.
    > 2. **Structure:** Follow the Arrange-Act-Assert (AAA) pattern strictly, and add clear comments for each section.
    > 3. **Naming Convention:** Use descriptive test names that explain the scenario and the expected outcome (e.g., `methodName_stateUnderTest_expectedBehavior`).
    > 4. **Rigorous Validation:** Do not just test the happy path. Thoroughly validate the core algorithmic logic. Include edge cases, boundary conditions (such as 0, negative numbers, empty arrays/sets, or null inputs), and verify base cases if recursion is involved.
    > 5. **Isolation:** Ensure each test is completely isolated and does not depend on the state of other tests.
    > 
    > 
    > Here is the Java code:"
    > `[הדבק את הקוד שלך כאן]`

    ---

    ### למה הפרומפט הזה עובד כל כך טוב?

    * **הגדרת סביבה מפורשת:** ציון JUnit 5 ו-Mockito מוודא שהקוד שייווצר יתאים לסטנדרט המודרני של פרויקטי Java ב-Gradle, וימנע שימוש בספריות מיושנות כמו JUnit 4.
    * **דרישה לקפדנות מתמטית ולוגית:** ההנחיה בודקת גבולות (Boundary conditions) ומקרי קצה בצורה אקטיבית. כשכותבים קוד שדורש חישובים מדויקים או טיפול במבני נתונים מורכבים, אי אפשר להסתמך רק על בדיקות בסיסיות, וחובה לוודא שההנחות של האלגוריתם מחזיקות מים גם בתנאי הקיצון.
    * **מבנה קריא:** הדרישה לתבנית ה-AAA (Arrange-Act-Assert) מבטיחה שהבדיקות ש-Copilot ייצר יהיו מסודרות, קריאות וקלות לתחזוקה או לשינוי בהמשך.

    האם תרצה שאדגים לך אילו שורות צריך להוסיף לקובץ ה-`build.gradle` שלך כדי לוודא שהספריות (JUnit 5 ו-Mockito) מוגדרות כראוי והבדיקות ירוצו בהצלחה?