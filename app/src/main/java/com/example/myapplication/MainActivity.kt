package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "startPage", modifier = modifier) {
        composable("startPage") {StartPage(navController) }
        composable("introPage") { IntroPage() }
        composable("registrationPage") { RegistrationPage() }
        composable("loginPage") { LoginPage() }
    }
}

@Composable
fun StartPage(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF99FFFF), Color(0xFF16166B))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.kayitechlogowhite),
                contentDescription ="Kayitech Logo",
                modifier = Modifier
                    .size(300.dp)

            )

            Text(
                text = "Master Your Studies,  One\nClick at a Time.",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 75.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    modifier = Modifier.padding(start = 25.dp),
                    text = "Quizzes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
                )

                ColoredCircleWithImage(
                    color = Color(0xFF2A5085),
                    opacity = 0.5f,
                    imageResId = R.drawable.quizicon,
                    contentDescription = "Circle with Image",
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = -40.dp, y = (-30.dp))

                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-15).dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    modifier = Modifier.padding(start = 25.dp),
                    text = "Flashcards",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
                )

                ColoredCircleWithImage(
                    color = Color(0xFF25436F),
                    opacity = 0.5f,
                    imageResId = R.drawable.flashcardicon,
                    contentDescription = "Circle with Image",
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = -20.dp, y = (-30.dp))

                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-25).dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    modifier = Modifier.padding(start = 25.dp),
                    text = "More...",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
                )

                ColoredCircleWithImage(
                    color = Color(0xFF172B47),
                    opacity = 0.5f,
                    imageResId = R.drawable.moreicon,
                    contentDescription = "Circle with Image",
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = -40.dp, y = (-30.dp))

                )


            }
            Button(onClick = {navController.navigate("introPage")},
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Get Started")
            }

        }

    }
}

@Composable
fun ColoredCircleWithImage (
    color: Color,
    opacity: Float = 1f,
    imageResId: Int? = null,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .clip(CircleShape)
            .background(color.copy(alpha = opacity))

    ) {
        imageResId?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = contentDescription,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(0.9f)
            )
        }
    }
}

@Composable
fun IntroPage(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8F4FF)),
    ) { 
        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.learningillustration),
                contentDescription ="Kayitech Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .aspectRatio(307f / 347f)
                    .clip(RoundedCornerShape(25.dp))

            )
            Text(
                text = "Books? Nah.\nWe've Got the Answers.",
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
            )
            Text(
                text = "Unlock study hacks, quizzes,\nflaschards, and tools to level up your\ngrades fast!",
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 45.dp)
            )
            Spacer(modifier = Modifier
                .weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp),
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                Button(onClick = {navController.navigate("introPage")},
                    modifier = Modifier.shadow(elevation = 9.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Register")

                }

                Button(onClick = {navController.navigate("introPage")},
                    modifier = Modifier.shadow(elevation = 9.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF99FFFF),
                        contentColor = Color.Black
                    )
                ) {
                    Text("Sign in")

                }

            }

        }

    }
}

@Composable
fun RegistrationPage(navController: NavHostController = rememberNavController(),
                     modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8F4FF)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 55.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,


            ) {

                IconButton(
                    modifier = Modifier
                        .size(45.dp),
                    onClick = {
                /*TODO: Handle back navigation*/}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }





                Text(

                    text = ("Register"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier
                        .size(45.dp)
                )





            }

            Text(
                text = ("Create Your Account"),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier
                .height(15.dp))

            OutlinedTextField(
                value = "First Name",
                onValueChange = { firstName = it},
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)

            )

            OutlinedTextField(
                value = "Last Name",
                onValueChange = { lastName = it},
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            OutlinedTextField(
                value = "Email",
                onValueChange = { email = it},
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            OutlinedTextField(
                value = "Password",
                onValueChange = { password = it},
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            OutlinedTextField(
                value = "Confirm Password",
                onValueChange = { confirmPassword = it},
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = ("By registering you are agreeing to our terms\nof service and privacy policy"),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier
                .height(15.dp))

            Button(onClick = {/*TODO: Navigate to login page*/},
                modifier = Modifier
                    .shadow(elevation = 9.dp)
                    .width(150.dp)
                    .border(2.dp, color = Color(0xFFFFFFFF), RoundedCornerShape(7.dp)),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF99FFFF),
                    contentColor = Color.Black
                )
            ) {
                Text("Sign in")

            }

            Spacer(modifier = Modifier
                .height(15.dp))


            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
                ) {

                Text(modifier = Modifier
                    .padding(bottom = 45.dp),
                    text = ("Already have an account?"),
                    textAlign = TextAlign.Center
                )

            }



        }

    }
}

@Composable
fun LoginPage(navController: NavHostController = rememberNavController()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember {mutableStateOf(false)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F4FF)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.kayitechlogoblue),
                contentDescription ="Kayitech Logo",
                modifier = Modifier
                    .size(300.dp)

            )

            Text(
                text = ("Hello Again!"),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier
                .height(15.dp))

            Text(
                text = ("Welcome back, you've\nbeen missed"),
                fontSize = 20.sp,
                textAlign = TextAlign.Center

            )

            Spacer(modifier = Modifier
                .height(25.dp))

            OutlinedTextField(
                value = "Email",
                onValueChange = { email = it},
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            OutlinedTextField(
                value = "Password",
                onValueChange = { password = it},
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Person")},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .border(
                        2.dp, color = Color(0xFF99FFFF),
                        RoundedCornerShape(7.dp)
                    ),
                shape = RoundedCornerShape(7.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .wrapContentWidth()

                ) {

                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it }

                    )

                    Text (
                        text = "Remember Me"
                    )

                }
            }

            Spacer(modifier = Modifier
                .weight(1f)
            )

            Button(onClick = {/*TODO: Navigate to login page*/},
                modifier = Modifier
                    .shadow(elevation = 9.dp)
                    .width(150.dp)
                    .border(2.dp, color = Color(0xFFFFFFFF), RoundedCornerShape(7.dp)),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF99FFFF),
                    contentColor = Color.Black
                )
            ) {
                Text("Login")

            }

            Text(modifier = Modifier
                .padding(bottom = 45.dp),
                text = ("Don't have an account?"),
                textAlign = TextAlign.Center
            )

    }   }
}



@Composable
fun QuizzesPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            // Custom Bottom Bar Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }

                    Text(
                        text = ("Home"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Home")
                    }

                    Text(
                        text = ("Settings"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Home")
                    }

                    Text(
                        text = ("Updates"),
                        textAlign = TextAlign.Center,
                    )

                }

            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F4FF))
                .padding(innerPadding), // Apply innerPadding here
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF8F4FF)),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color(0xFF1D3557)),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                        }

                        Spacer(modifier = Modifier
                            .height(15.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {

                            OutlinedTextField(
                                value = "",
                                onValueChange = {/*TODO: Handle search input change*/},
                                placeholder = { Text("Search Quizzes")},
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .border(2.dp, color = Color(0xFF99FFFF), RoundedCornerShape(50)),
                                shape = RoundedCornerShape(50),
                            )

                            IconButton(onClick = {
                                /*TODO: Handle search button click*/
                            }, modifier = Modifier
                                .clip(CircleShape)
                                .background(color = Color(0xFF99FFFF))) {

                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Search",
                                    tint = Color.Black
                                )

                            }

                        }

                        Row (modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "Quizzes",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color.Black
                            )

                            IconButton(
                                onClick = {/*TODO: Handle filter click*/},
                                modifier = Modifier
                                    .background(color = Color(0xFF1D3557), shape = RoundedCornerShape(7.dp))


                            ) {
                                Icon(
                                    imageVector = Icons.Filled.List,
                                    contentDescription="Filter",
                                    tint = Color.White
                                )
                            }


                        }




                    }




                }
            }
            }
        }

}

@Composable
fun FlashcardsPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            // Custom Bottom Bar Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }

                    Text(
                        text = ("Home"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Home")
                    }

                    Text(
                        text = ("Settings"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Home")
                    }

                    Text(
                        text = ("Updates"),
                        textAlign = TextAlign.Center,
                    )

                }

            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F4FF))
                .padding(innerPadding), // Apply innerPadding here
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF8F4FF)),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color(0xFF1D3557)),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                        }

                        Spacer(modifier = Modifier
                            .height(15.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {

                            OutlinedTextField(
                                value = "",
                                onValueChange = {/*TODO: Handle search input change*/},
                                placeholder = { Text("Search Quizzes")},
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .border(2.dp, color = Color(0xFF99FFFF), RoundedCornerShape(50)),
                                shape = RoundedCornerShape(50),
                            )

                            IconButton(onClick = {
                                /*TODO: Handle search button click*/
                            }, modifier = Modifier
                                .clip(CircleShape)
                                .background(color = Color(0xFF99FFFF))) {

                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Search",
                                    tint = Color.Black
                                )

                            }

                        }

                        Row (modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "Flashcards",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color.Black
                            )

                            IconButton(
                                onClick = {/*TODO: Handle filter click*/},
                                modifier = Modifier
                                    .background(color = Color(0xFF1D3557), shape = RoundedCornerShape(7.dp))


                            ) {
                                Icon(
                                    imageVector = Icons.Filled.List,
                                    contentDescription="Filter",
                                    tint = Color.White
                                )
                            }


                        }




                    }




                }
            }
        }
    }

}

@Composable
fun WishlistPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            // Custom Bottom Bar Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }

                    Text(
                        text = ("Home"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Home")
                    }

                    Text(
                        text = ("Settings"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Home")
                    }

                    Text(
                        text = ("Updates"),
                        textAlign = TextAlign.Center,
                    )

                }

            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F4FF))
                .padding(innerPadding), // Apply innerPadding here
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF8F4FF)),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color(0xFF1D3557)),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                        }

                        Spacer(modifier = Modifier
                            .height(15.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {

                            OutlinedTextField(
                                value = "",
                                onValueChange = {/*TODO: Handle search input change*/},
                                placeholder = { Text("Search Quizzes")},
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .border(2.dp, color = Color(0xFF99FFFF), RoundedCornerShape(50)),
                                shape = RoundedCornerShape(50),
                            )

                            IconButton(onClick = {
                                /*TODO: Handle search button click*/
                            }, modifier = Modifier
                                .clip(CircleShape)
                                .background(color = Color(0xFF99FFFF))) {

                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Search",
                                    tint = Color.Black
                                )

                            }

                        }

                        Row (modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "Wishlist",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color.Black
                            )

                            IconButton(
                                onClick = {/*TODO: Handle filter click*/},
                                modifier = Modifier
                                    .background(color = Color(0xFF1D3557), shape = RoundedCornerShape(7.dp))


                            ) {
                                Icon(
                                    imageVector = Icons.Filled.List,
                                    contentDescription="Filter",
                                    tint = Color.White
                                )
                            }


                        }




                    }




                }
            }
        }
    }

}

@Composable
fun LeaderboardPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            // Custom Bottom Bar Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }

                    Text(
                        text = ("Home"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Home")
                    }

                    Text(
                        text = ("Settings"),
                        textAlign = TextAlign.Center,
                    )

                }

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    IconButton(onClick = { /*TODO: Handle home click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Home")
                    }

                    Text(
                        text = ("Updates"),
                        textAlign = TextAlign.Center,
                    )

                }

            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F4FF))
                .padding(innerPadding), // Apply innerPadding here
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF8F4FF)),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color(0xFF1D3557)),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = {/*TODO: Handle navigation drawer toggle*/}) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }

                        }

                        Spacer(modifier = Modifier
                            .height(15.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {

                            OutlinedTextField(
                                value = "",
                                onValueChange = {/*TODO: Handle search input change*/},
                                placeholder = { Text("Search Quizzes")},
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .border(2.dp, color = Color(0xFF99FFFF), RoundedCornerShape(50)),
                                shape = RoundedCornerShape(50),
                            )

                            IconButton(onClick = {
                                /*TODO: Handle search button click*/
                            }, modifier = Modifier
                                .clip(CircleShape)
                                .background(color = Color(0xFF99FFFF))) {

                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Search",
                                    tint = Color.Black
                                )

                            }

                        }

                        Row (modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "Leaderboard",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = Color.Black
                            )

                            IconButton(
                                onClick = {/*TODO: Handle filter click*/},
                                modifier = Modifier
                                    .background(color = Color(0xFF1D3557), shape = RoundedCornerShape(7.dp))


                            ) {
                                Icon(
                                    imageVector = Icons.Filled.List,
                                    contentDescription="Filter",
                                    tint = Color.White
                                )
                            }


                        }




                    }




                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GradientBackgroundPreview() {
    MyApplicationTheme {
        StartPage(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun IntroPagePreview() {
    MyApplicationTheme {
        IntroPage()
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview() {
    MyApplicationTheme {
        RegistrationPage()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    MyApplicationTheme {
        LoginPage()
    }
}

@Preview(showBackground = true)
@Composable
fun QuizzesPagePreview() {
    MyApplicationTheme {
        QuizzesPage()
    }
}

@Preview(showBackground = true)
@Composable
fun FlashcardsPagePreview() {
    MyApplicationTheme {
        FlashcardsPage()
    }
}

@Preview(showBackground = true)
@Composable
fun WishlistPagePreview() {
    MyApplicationTheme {
        WishlistPage()
    }
}

@Preview(showBackground = true)
@Composable
fun LeaderboardPagePreview() {
    MyApplicationTheme {
        LeaderboardPage()
    }
}