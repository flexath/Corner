package com.flexath.corner.features.main.data.remote.dto.dummy

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

data class PostVO(
    val id: Int?,
    val userId: Int?,
    val title: String?,
    val slug: String?,
    val description: String?,
    val categoryId: Int?,
    val status: Int?,
    val type: Int?,
    val viewCount: Int?,
    val readMin: String?,
    val reference: String?,
    val authorName: String?,
    val likeCount: Int?,
    val commentCount: Int?,
    val createdDate: LocalDateTime?,
    val content: String?
)

@RequiresApi(Build.VERSION_CODES.O)
val dummyPostList = listOf(
    PostVO(
        id = 1,
        userId = 101,
        title = "Understanding Kotlin Basics",
        slug = "understanding-kotlin-basics",
        description = "An introductory guide to Kotlin programming language.",
        categoryId = 1,
        status = 1,
        type = 1,
        viewCount = 1500,
        readMin = "5 min read",
        reference = "https://kotlinlang.org",
        authorName = "John Doe",
        likeCount = 200,
        commentCount = 50,
        createdDate = LocalDateTime.of(2023, 6, 1, 10, 0),
        content = "Kotlin is a modern programming language that makes developers happier. It's concise, safe, and fully interoperable with Java."
    ),
    PostVO(
        id = 2,
        userId = 102,
        title = "Advanced Kotlin Features",
        slug = "advanced-kotlin-features",
        description = "Dive deep into advanced features of Kotlin.",
        categoryId = 1,
        status = 1,
        type = 2,
        viewCount = 1200,
        readMin = "10 min read",
        reference = "https://kotlinlang.org/docs/reference/advanced.html",
        authorName = "Jane Smith",
        likeCount = 150,
        commentCount = 30,
        createdDate = LocalDateTime.of(2023, 6, 5, 14, 30),
        content = "Explore advanced features like coroutines, type-safe builders, and more to leverage Kotlin's powerful capabilities."
    ),
    PostVO(
        id = 3,
        userId = 103,
        title = "Kotlin Coroutines Explained",
        slug = "kotlin-coroutines-explained",
        description = "A comprehensive guide to understanding Kotlin coroutines.",
        categoryId = 2,
        status = 1,
        type = 1,
        viewCount = 900,
        readMin = "8 min read",
        reference = "https://kotlinlang.org/docs/coroutines-guide.html",
        authorName = "Emily Johnson",
        likeCount = 180,
        commentCount = 40,
        createdDate = LocalDateTime.of(2023, 6, 10, 9, 15),
        content = "Coroutines provide a way to write asynchronous code sequentially. They simplify async programming and are highly efficient."
    ),
    PostVO(
        id = 4,
        userId = 104,
        title = "Kotlin vs Java: A Comparison",
        slug = "kotlin-vs-java-comparison",
        description = "Comparing Kotlin and Java in various aspects.",
        categoryId = 3,
        status = 1,
        type = 1,
        viewCount = 1800,
        readMin = "7 min read",
        reference = "https://kotlinlang.org/docs/kotlin-vs-java.html",
        authorName = "Michael Brown",
        likeCount = 250,
        commentCount = 60,
        createdDate = LocalDateTime.of(2023, 6, 15, 11, 45),
        content = "Kotlin offers many improvements over Java including null safety, extension functions, and more concise syntax."
    ),
    PostVO(
        id = 5,
        userId = 105,
        title = "Using Kotlin with Android",
        slug = "using-kotlin-with-android",
        description = "Learn how to use Kotlin for Android development.",
        categoryId = 4,
        status = 1,
        type = 1,
        viewCount = 2000,
        readMin = "6 min read",
        reference = "https://developer.android.com/kotlin",
        authorName = "Sarah Davis",
        likeCount = 300,
        commentCount = 70,
        createdDate = LocalDateTime.of(2023, 6, 20, 16, 0),
        content = "Kotlin is fully supported for Android development. Discover how to set up your project, use Android extensions, and more."
    ),
    PostVO(
        id = 6,
        userId = 106,
        title = "Functional Programming in Kotlin",
        slug = "functional-programming-kotlin",
        description = "An introduction to functional programming concepts in Kotlin.",
        categoryId = 2,
        status = 1,
        type = 2,
        viewCount = 1100,
        readMin = "9 min read",
        reference = "https://kotlinlang.org/docs/reference/functional-programming.html",
        authorName = "Chris Wilson",
        likeCount = 220,
        commentCount = 35,
        createdDate = LocalDateTime.of(2023, 6, 25, 13, 30),
        content = "Kotlin supports functional programming paradigms. Learn about lambdas, higher-order functions, and immutability."
    ),
    PostVO(
        id = 7,
        userId = 107,
        title = "Kotlin for Server-Side Development",
        slug = "kotlin-server-side-development",
        description = "Explore the use of Kotlin for server-side applications.",
        categoryId = 5,
        status = 1,
        type = 2,
        viewCount = 950,
        readMin = "12 min read",
        reference = "https://kotlinlang.org/docs/server-side.html",
        authorName = "Jessica Martinez",
        likeCount = 170,
        commentCount = 25,
        createdDate = LocalDateTime.of(2023, 7, 1, 10, 15),
        content = "Kotlin is not just for Android. It's also a great choice for server-side development with frameworks like Ktor and Spring."
    ),
    PostVO(
        id = 8,
        userId = 108,
        title = "Kotlin Standard Library",
        slug = "kotlin-standard-library",
        description = "An overview of Kotlin's standard library.",
        categoryId = 1,
        status = 1,
        type = 1,
        viewCount = 1150,
        readMin = "5 min read",
        reference = "https://kotlinlang.org/api/latest/jvm/stdlib/",
        authorName = "Daniel Hernandez",
        likeCount = 200,
        commentCount = 45,
        createdDate = LocalDateTime.of(2023, 7, 5, 12, 0),
        content = "Kotlin's standard library provides numerous utilities and extensions to the Java standard library to improve your productivity."
    ),
    PostVO(
        id = 9,
        userId = 109,
        title = "Kotlin Extensions and Utilities",
        slug = "kotlin-extensions-utilities",
        description = "Learn about various Kotlin extensions and utility functions.",
        categoryId = 3,
        status = 1,
        type = 2,
        viewCount = 1300,
        readMin = "7 min read",
        reference = "https://kotlinlang.org/docs/reference/extensions.html",
        authorName = "Paul Anderson",
        likeCount = 190,
        commentCount = 55,
        createdDate = LocalDateTime.of(2023, 7, 10, 14, 30),
        content = "Kotlin extensions add functionality to existing classes without modifying their source code. Discover how to use them effectively."
    ),
    PostVO(
        id = 10,
        userId = 110,
        title = "Migrating from Java to Kotlin",
        slug = "migrating-java-kotlin",
        description = "A guide for Java developers to migrate to Kotlin.",
        categoryId = 3,
        status = 1,
        type = 1,
        viewCount = 1450,
        readMin = "6 min read",
        reference = "https://kotlinlang.org/docs/migrating-from-java.html",
        authorName = "Laura Thompson",
        likeCount = 210,
        commentCount = 60,
        createdDate = LocalDateTime.of(2023, 7, 15, 11, 0),
        content = "Transitioning from Java to Kotlin is seamless. Learn the steps involved and the benefits you'll gain from making the switch."
    ),
    PostVO(
        id = 11,
        userId = 201,
        title = "Introduction to Jetpack Compose",
        slug = "introduction-jetpack-compose",
        description = "Getting started with Jetpack Compose for modern Android UI development.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1600,
        readMin = "6 min read",
        reference = "https://developer.android.com/jetpack/compose",
        authorName = "Alice Cooper",
        likeCount = 250,
        commentCount = 65,
        createdDate = LocalDateTime.of(2023, 8, 1, 10, 0),
        content = "Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
    ),
    PostVO(
        id = 12,
        userId = 202,
        title = "Building Layouts with Compose",
        slug = "building-layouts-compose",
        description = "Learn how to build layouts using Jetpack Compose.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1300,
        readMin = "7 min read",
        reference = "https://developer.android.com/jetpack/compose/layouts",
        authorName = "Bob Anderson",
        likeCount = 220,
        commentCount = 40,
        createdDate = LocalDateTime.of(2023, 8, 5, 12, 30),
        content = "With Jetpack Compose, building layouts is simple and intuitive. Discover how to create complex layouts using Compose's layout APIs."
    ),
    PostVO(
        id = 13,
        userId = 203,
        title = "State Management in Jetpack Compose",
        slug = "state-management-compose",
        description = "Manage state efficiently in Jetpack Compose applications.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1500,
        readMin = "8 min read",
        reference = "https://developer.android.com/jetpack/compose/state",
        authorName = "Catherine Lee",
        likeCount = 230,
        commentCount = 50,
        createdDate = LocalDateTime.of(2023, 8, 10, 11, 15),
        content = "State management is a crucial aspect of any application. Learn how to handle state in Jetpack Compose efficiently and effectively."
    ),
    PostVO(
        id = 14,
        userId = 204,
        title = "Navigation in Jetpack Compose",
        slug = "navigation-jetpack-compose",
        description = "Implementing navigation in Jetpack Compose applications.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1700,
        readMin = "9 min read",
        reference = "https://developer.android.com/jetpack/compose/navigation",
        authorName = "David Miller",
        likeCount = 280,
        commentCount = 60,
        createdDate = LocalDateTime.of(2023, 8, 15, 10, 45),
        content = "Navigation in Jetpack Compose is simple and powerful. Learn how to navigate between screens and pass data in your Compose app."
    ),
    PostVO(
        id = 15,
        userId = 205,
        title = "Animating UI in Jetpack Compose",
        slug = "animating-ui-jetpack-compose",
        description = "A guide to creating animations in Jetpack Compose.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1900,
        readMin = "10 min read",
        reference = "https://developer.android.com/jetpack/compose/animation",
        authorName = "Emma Wilson",
        likeCount = 300,
        commentCount = 70,
        createdDate = LocalDateTime.of(2023, 8, 20, 12, 30),
        content = "Animations add a delightful user experience to your app. Explore how to create and manage animations in Jetpack Compose."
    ),
    PostVO(
        id = 16,
        userId = 206,
        title = "Testing in Jetpack Compose",
        slug = "testing-jetpack-compose",
        description = "Learn how to write tests for Jetpack Compose UI.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1400,
        readMin = "6 min read",
        reference = "https://developer.android.com/jetpack/compose/testing",
        authorName = "Frank Garcia",
        likeCount = 210,
        commentCount = 35,
        createdDate = LocalDateTime.of(2023, 8, 25, 14, 45),
        content = "Testing is an integral part of app development. Discover how to write effective tests for your Jetpack Compose components."
    ),
    PostVO(
        id = 17,
        userId = 207,
        title = "Handling Gestures in Jetpack Compose",
        slug = "handling-gestures-jetpack-compose",
        description = "Implementing gesture handling in Jetpack Compose.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1200,
        readMin = "8 min read",
        reference = "https://developer.android.com/jetpack/compose/gestures",
        authorName = "Grace Adams",
        likeCount = 230,
        commentCount = 50,
        createdDate = LocalDateTime.of(2023, 8, 30, 11, 0),
        content = "Gestures are crucial for interactive applications. Learn how to handle gestures like swipe, drag, and pinch in Jetpack Compose."
    ),
    PostVO(
        id = 18,
        userId = 208,
        title = "Compose and ViewModel Integration",
        slug = "compose-viewmodel-integration",
        description = "Integrating Jetpack Compose with ViewModel for state management.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1100,
        readMin = "9 min read",
        reference = "https://developer.android.com/jetpack/compose/state#viewmodel",
        authorName = "Henry Brooks",
        likeCount = 220,
        commentCount = 45,
        createdDate = LocalDateTime.of(2023, 9, 5, 9, 30),
        content = "ViewModel plays a crucial role in managing UI-related data in a lifecycle-conscious way. Learn how to integrate it with Jetpack Compose."
    ),
    PostVO(
        id = 19,
        userId = 209,
        title = "Migrating to Jetpack Compose",
        slug = "migrating-to-jetpack-compose",
        description = "A guide for migrating your existing Android project to Jetpack Compose.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1750,
        readMin = "10 min read",
        reference = "https://developer.android.com/jetpack/compose/migration",
        authorName = "Irene Walker",
        likeCount = 260,
        commentCount = 65,
        createdDate = LocalDateTime.of(2023, 9, 10, 13, 0),
        content = "Migrating to Jetpack Compose can modernize your app and improve developer productivity. Follow this guide for a smooth transition."
    ),
    PostVO(
        id = 20,
        userId = 210,
        title = "Jetpack Compose Best Practices",
        slug = "jetpack-compose-best-practices",
        description = "Best practices for building applications with Jetpack Compose.",
        categoryId = 6,
        status = 1,
        type = 1,
        viewCount = 1850,
        readMin = "7 min read",
        reference = "https://developer.android.com/jetpack/compose/best-practices",
        authorName = "Jack Green",
        likeCount = 280,
        commentCount = 75,
        createdDate = LocalDateTime.of(2023, 9, 15, 10, 30),
        content = "Follow these best practices to build robust, maintainable, and efficient applications with Jetpack Compose."
    )
)

