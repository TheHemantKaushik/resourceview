[ ![Download](https://api.bintray.com/packages/thehemantkaushik/resourceview/com.thehemantkaushik%3Aresourceview/images/download.svg) ](https://bintray.com/thehemantkaushik/resourceview/com.thehemantkaushik%3Aresourceview/_latestVersion)

# ResourceView
ResourceView is a very useful library to handle resource states
e.g. loading, data or error. Here is some simple steps to use ResourceView:

<br/>

**1. Configure:**

// in project's build.gradle<br/>
`allprojects {`<br/>
`    repositories {`<br/>
`        jcenter({ url  "https://dl.bintray.com/thehemantkaushik/resourceview" })`<br/>
`    }`<br/>
`}`

// in app's build.gradle<br/>
`compile 'com.thehemantkaushik:resourceview:1.0.0-alpha2'`

<br/>

**2. Find view:**

// find/bind view<br/>
`ResourceView resourceView;` 

<br/>

**3. Show Loading:**

// show loader without any message <br/>
`resourceView.showLoadingLayout();`

// show loader with message by passing string resource id<br/>
`resourceView.showLoadingLayout(@StringRes int loaderMessage);`

// show loader with message by passing string<br/>
`resourceView.showLoadingLayout(String loaderMessage);`

// want to show custom layout for loading<br/>
`resourceView.showLoadingView(@LayoutRes int layoutRes);`

// want to show custom view for loading<br/>
`resourceView.showLoadingView(View view);`

<br/>

**4. Show Error:**

// show error message<br/>
`resourceView.showErrorLayout(String message);`

// show error image and message<br/>
`resourceView.showErrorLayout(int imageRes, String message);`

// show error message and action<br/>
`resourceView.showErrorLayout(String message, String actionButtonText, Runnable actionButtonCallback);`

// show error image, message and action<br/>
`resourceView.showErrorLayout(int imageRes, String message, String actionButtonText, Runnable actionButtonCallback);`

// show your own error layout by passing its resource id<br/>
`resourceView.showErrorView(@LayoutRes int layout);`

// show your own error view<br/>
`resourceView.showErrorView(View view);`

<br/>

**5. Show Contents:**

// to show actual contents, just call this method:<br/>
`resourceView.showContents();`
