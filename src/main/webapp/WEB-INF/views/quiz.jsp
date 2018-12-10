<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains - Step 2: Quiz</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cyborg/bootstrap.min.css">
		<style type="text/css">
			
			body {
				font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
			}
			
			p.lead {
				letter-spacing: 1px;
			}
			
			h3 {
				font-size:2em;
			}
			
			img {
				height:300px;
				width:300px;
			}
			
			.page-header {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
			.page-header h3 {
				font-size: 2em;
				line-height: 2;
			}
			
			.header-graphic {
				min-height: 500px;
				background-image: url("https://images3.alphacoders.com/637/637817.jpg");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center;
			}
			
			h1 {
				font-size: 5em;
				letter-spacing: -2px;
				line-height: 1;
			}
			
			h2, h3 {
				text-align: center;
			}
			
			#row1 {
				padding-top: 30px;
			}
			
			#call-to-action {
				padding-bottom: 20px;
			}
			
			#redletter {
				color: #fc0000;
			}
			#carouselfaces img {
				max-height: 600px;
				
			}
			
			#footer {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
		</style>
	</head>
	
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark site-header bg-dark sticky-top py-1">
			<div class="container">
				<a class="navbar-brand" href="#">H&V</a>
				<div>
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown show">
							<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="/" aria-expanded="true">
							About
							<span class="caret"></span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="aboutus">About The Team</a>
								<a class="dropdown-item" href="aboutproject">About The Project</a>
							</div>
						</li>
						
						<li class="nav-item"><a class="nav-link" href="legends">Legend</a></li>
						<li class="nav-item"><a class="nav-link" href="allusers">Meet The Others</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container">
		
			<div class="page-header">
				
				<h2>Step 2: Answer These Questions</h2>
			
			</div>
			
			<div class="row">
				
				<div class="col-md">
					
					<form class="form-group" action="quizresult">
						<h3>Your birthday is fast approaching, and your idea of attending a big party thrown in your honor is:</h3>
						<ol>
							<li><input type="radio" name="question1" value="happiness,0.0">I’m stoked, bring on the cake!</li>
							<li><input type="radio" name="question1" value="surprise,0.1">Uh-oh, panic poops.</li>
							<li><input type="radio" name="question1" value="neutral,0.1">I stopped counting after my 1st child.</li>
							<li><input type="radio" name="question1" value="anger,0.03">Who’s paying?</li>
							<li><input type="radio" name="question1" value="sadness,0.05">I don’t deserve this.</li>
						</ol>
						
						<h3>How do you feel before crossing a busy street?</h3>
						<div class="row">
						
						<ol>
							<li>	
								<label>
									<input type="radio" name="question2" value="sadness,0.05">						
									<img src=https://www.pinterest.com/pin/247135098282712098>
								</label>
							</li>
							
							<li>	
								<label>
									<input type="radio" name="question2" value="happiness,0.0" >
									<img src= https://2.bp.blogspot.com/-x6nbnvOIKD8/WmuhiXJHSHI/AAAAAAAAHZI/80UaJ9qngPw2fB4lYx6CBfvyA9hq2h1OwCLcBGAs/s320/Buzz_Lightyear_running.jpg/>
								</label>
							</li>
							
							<li>	
								<label>
									<input type="radio" name="question2" value="surprise,0.1" >
									<img src= https://vignette.wikia.nocookie.net/disney/images/1/14/Surprised_Alice.png/revision/latest/scale-to-width-down/632?cb=20131125031332/>
								</label>
							</li>
							
							<li>
								<label>
									<input type="radio" name="question2" value="neutral,0.1">
									<img src= https://lumiere-a.akamaihd.net/v1/images/tmb-sq_character-baymax_launch_f406f659.jpeg/>
								</label>
							</li>
							
							<li>	
								<label>
									<input type="radio" name="question2" value="anger,0.03">
									<img src=https://c8.alamy.com/comp/MABP97/donald-duck-illustration-cartoon-angry-MABP97.jpg>
								</label>
							</li>	
						</ol>
						
						</div>
						
						<h3>You're cornered by your enemies. Think fast! Weapon of choice?</h3>
						<ol>
							<li><input type="radio" name="question3" value="surprise,0.1"> Cast-iron frying pan.</li>
							<li><input type="radio" name="question3" value="happiness,0.0"> I can control climate, and am therefore, a god.</li>
							<li><input type="radio" name="question3" value="neutral,0.1"> Not worth the effort, I’m gardening.</li>
							<li><input type="radio" name="question3" value="anger,0.05"> Withering glare.</li>
							<li><input type="radio" name="question3" value="sadness,0.03"> Talk with me long enough, and I’ll drag you down with me.</li>
						</ol>
						
						<h3>It’s 6AM, and the Sun has fired her first peal of orange across the horizon. The new day is on its way inexorably through the blinds, and into your crusty eyeballs—this is your cue to:</h3>
						<ol>
							<li><input type="radio" name="question4" value="happiness,0.0">Seize the day; I’m thinking of doing as many as six impossible things before breakfast!</li>
							<li><input type="radio" name="question4" value="surprise,0.1">Oh crap, I’ve got all that stuff I’ve got to do! (Charges like bull through Pfaltzgraff’s)</li>
							<li><input type="radio" name="question4" value="neutral,0.1">Gee, I’ve only just noticed how much this blanket feels like heaven… (Hits the snooze)</li>
							<li><input type="radio" name="question4" value="anger,0.05">Whoever or whatever is trying to wake me up is about meet their end via deadblow mallet.</li>
							<li><input type="radio" name="question4" value="sadness,0.03">I must invite you… to just leave me alone. (Draws curtains)</li>
						</ol>
						
						<h3>Which quote do you identify with the most?</h3>
						<ol>
							<li><input type="radio" name="question5" value="neutral,0.1">"Your identity is your most valuable possession. Protect it."!</li>
							<li><input type="radio" name="question5" value="surprise,0.1">“It’s true love!”</li>
							<li><input type="radio" name="question5" value="anger,0.05">“I never go back on my word!”</li>
							<li><input type="radio" name="question5" value="sadness,0.03">“Forever is a long time, and time has a way of changing things.”</li>
							<li><input type="radio" name="question5" value="happiness,0.0">"Venture outside your comfort zone. The rewards are worth it."</li>
						</ol>
						
						<input id="button" class="btn btn-secondary" type = "submit" value = "Submit">
					</form>
					
				</div>
			
			</div>
			
			<div id="footer" class="row">
				<div class="col-md">
					
				</div>
				<div class="col-md">
					<small>©2018 Heroes & Villains Doppelganger Project.</small>
					<br>
					<small>All Disney characters are ©Disney. All rights reserved.</small>
				</div>
				<div class="col-md">
			
				</div>
			</div>
		
		</div>
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>