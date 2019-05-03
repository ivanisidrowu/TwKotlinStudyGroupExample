# TwKotlinStudyGroupExample
Kotlin examples for study group in Taiwan Kotlin User Group

Check out the description below or go to speaker deck for more information.

SpeakerDeck: https://speakerdeck.com/ivanw/using-kotlin-in-android

## Examples
1. Null safety
2. Data class
3. Default arguments/implementations

## Null Safety
* Eliminate the danger of null references from code
* Nullable types and Non-Null Types

#### Non-Null types
```kotlin
var a: String = "abc"
a = null // compilation error
```

#### Nullable types
```kotlin
var b: String? = "abc"
b = null // ok
```

#### Example 1
Java
```java
Bundle args = getArguments();
if (args != null) {
   Bundle data = args.getBundle(KEY_DATA);
   if (data != null) {
       Log.d(TAG, data.getString(KEY_NAME));
   }
}
```
Kotlin
```kotlin
Log.d(TAG, arguments?.getBundle(KEY_DATA)?.getString(KEY_NAME))
```

## Data Class

It automatically generates
* equals() / hashCode()
* getters and setters
* toString()
* copy()

#### Example 2
Java
```java
public class JavaUser implements Parcelable {
    private long id;
    private String name;
    private String address;
    private String description;
    private String profileImageUrl;

    public JavaUser(long id, String name, String description, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.profileImageUrl = profileImageUrl;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.description);
        dest.writeString(this.profileImageUrl);
    }

    public JavaUser(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.profileImageUrl = in.readString();
    }

    public static final Parcelable.Creator<JavaUser> CREATOR = new Parcelable.Creator<JavaUser>() {
        @Override
        public JavaUser createFromParcel(Parcel source) {
            return new JavaUser(source);
        }

        @Override
        public JavaUser[] newArray(int size) {
            return new JavaUser[size];
        }
    };
}
```

Kotlin
```kotlin
@Parcelize
data class KotlinUser(val id: Long,
                      val name: String,
                      val description: String,
                      val profileImageUrl: String) : Parcelable
```
## Default Argument/Implementation
Java overloads can be replaced with one function in Kotlin

#### Example 3
Java
```java
private void sendInfo(String content, long Time, String tag) { /* ... */ }
private void sendInfo(String content, long Time) { /* ... */ }
private void sendInfo(String content, String tag) { /* ... */ }
private void sendInfo(String content) { /* ... */ }
```

Kotlin
```kotlin
private fun sendInfo(
   content: String,
   time: Long = Date().time,
   tag: String = TAG
) { … }

sendInfo("content", time = Date().time)
```

#### Example 4
Java
```java
TextView textView = view.findViewById(R.id.text);
textView.animate()
        .alpha(0f)
        .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
```

Kotlin
```kotlin
val textView = view.findViewById<TextView>(R.id.text)
        textView.animate()
            .alpha(0f)
            .setListener(
                onAnimationStart = {
                    // animation started!
                },
                onAnimationEnd = {
                    // animation ended!
                }
            )
```
