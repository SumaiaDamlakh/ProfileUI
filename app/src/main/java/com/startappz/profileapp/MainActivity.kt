package com.startappz.profileapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.startappz.profileapp.ui.theme.ProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                // A surface container using the 'background' color from the theme
                Profile()
            }
        }
    }
}

@Preview
@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        ConstraintLayout {
            val (topImage, profile) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.top_background), contentDescription = "", modifier =
                Modifier
                    .fillMaxWidth()
                    .constrainAs(topImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)

                    }
            )

            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = "", modifier =
                Modifier
                    .constrainAs(profile) {
                        top.linkTo(topImage.bottom)
                        bottom.linkTo(topImage.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    })
        }

        Text(
            text = "Lion Fischer",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp),
            color = Color(android.graphics.Color.parseColor("#747679")),

            )


        Text(
            text = "lion.Fischer@gmail.com",
            fontSize = 20.sp,
            color = Color(android.graphics.Color.parseColor("#747679")),
        )


        addButton("My Reviews", R.drawable.ic_1) {

        }

        addButton("Account Settings", R.drawable.ic_2) {}
        addButton("Personal Information", R.drawable.ic_3) {}
        addButton("Notification", R.drawable.ic_4) {}
        addButton("Fingerprint Settings", R.drawable.ic_5) {}

        Button(
            onClick = {},
            Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#373ebf"))

            ), shape = RoundedCornerShape(50)
        ) {
            Text(text = "Back to Main Page")
        }
    }
}


@Composable
fun addButton(buttonText: String, buttonDrawableID: Int, onClickAction: () -> Unit) {
    Button(
        onClick = { onClickAction()
            Log.d("TAG TAG", buttonText)},
        Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(android.graphics.Color.parseColor("#ffffff"))

        ), shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = buttonDrawableID),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 5.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = buttonText, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)

        }

    }
}


//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileAppTheme {
    }
}