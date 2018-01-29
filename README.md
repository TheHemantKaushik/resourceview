# ResourceView
ResourceView is a very useful library to handle resource states
e.g. loading, data or error. Here is some simple steps to use ResourceView:

<br/>

**1. Add dependency:**

// in project's build.gradle<br/>
`allprojects {`<br/>
`    repositories {`<br/>
`        jcenter({ url  "https://dl.bintray.com/thehemantkaushik/resourceview" })`<br/>
`    }`<br/>
`}`

// in app's build.gradle<br/>
`compile 'com.thehemantkaushik:resourceview:1.0.0-alpha1'`

<br/>

**2. Find view:**

// find view<br/>
`ResourceView resourceView;` 

<br/>

**3. Show Loading:**

// show loader without any message <br/>
`resourceView.showLoadingLayout();`

// show loader with message by passing string resource id<br/>
`resourceView.showLoadingLayout(@StringRes int loaderMessage);`

// show loader with message by passing string<br/>
`resourceView.showLoadingLayout(String loaderMessage);`

<br/>

**4. Show Error:**

// show error layout by passing string resource id<br/>
`resourceView.showErrorLayout(@StringRes int errorMessageRes);`

// show error layout by passing an image resource and message resource<br/>
`resourceView.showErrorLayout(@DrawableRes int errorImageRes, @StringRes int errorMessageRes);`

// show error layout by passing error message string resource, button name string resource and a listener to listen button click <br/>
`resourceView.showErrorLayout(@StringRes int errorMessageRes, @StringRes int errorButtonTextRes, @Nullable View.OnClickListener errorButtonClickListener);`

// show error layout by passing drawable resource, error message string resource, button name string resource and a listener to listen button click <br/>
`resourceView.showErrorLayout(@DrawableRes int errorImageRes, @StringRes int errorMessageRes, @StringRes int errorButtonTextRes, @Nullable View.OnClickListener errorButtonClickListener);`

<br/>

**5. Show Contents:**

// to show actual contents, just call this method:<br/>
`resourceView.showContents();`
