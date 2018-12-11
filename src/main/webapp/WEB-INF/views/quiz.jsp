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
			
			#question1 {
				height:300px;
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
			
			h1 {
				font-size: 5em;
				letter-spacing: -2px;
				line-height: 1;
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
				<a class="navbar-brand" href="/">H&V</a>
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
						
						<div id="question1" class="row">
						<div class="col-md">
						<h3>1. Your birthday is fast approaching, and your idea of attending a big party thrown in your honor is:</h3>
						<ol>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="question1" value="happiness">I’m stoked, bring on the cake!
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="question1" value="surprise">Uh-oh, panic poops.
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="question1" value="neutral">I stopped counting after my 1st child.
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="question1" value="anger">Who’s paying?
									</label>	
								</div>		
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="question1" value="sadness">I don’t deserve this.
									</label>
								</div>
							</li>
						</ol>
						</div>
						<div class="col-sm"></div>
						</div>
						
						
						<h3>2. How do you feel before crossing a busy street?</h3>
						<div class="row">
						
						<ol>
							<li>	
								<div class="form-check">
									<label class="form-check-label">
									<input class="form-check-input" type="radio" name="question2" value="sadness">						
									<img src=https://www.pinterest.com/pin/247135098282712098>
								</label>
								</div>
							</li>
							
							<li>	
								<div class="form-check">
									<label class="form-check-label">
									<input class="form-check-input" type="radio" name="question2" value="happiness" >
									<img src= https://2.bp.blogspot.com/-x6nbnvOIKD8/WmuhiXJHSHI/AAAAAAAAHZI/80UaJ9qngPw2fB4lYx6CBfvyA9hq2h1OwCLcBGAs/s320/Buzz_Lightyear_running.jpg/>
								</label>
								</div>
							</li>
							
							<li>	
								<div class="form-check">
									<label class="form-check-label">
									<input class="form-check-input" type="radio" name="question2" value="surprise" >
									<img src= https://vignette.wikia.nocookie.net/disney/images/1/14/Surprised_Alice.png/revision/latest/scale-to-width-down/632?cb=20131125031332/>
								</label>
								</div>
							</li>
							
							<li>
								<div class="form-check">
									<label class="form-check-label">
									<input class="form-check-input" type="radio" name="question2" value="neutral">
									<img src= https://lumiere-a.akamaihd.net/v1/images/tmb-sq_character-baymax_launch_f406f659.jpeg/>
								</label>
								</div>
							</li>
							
							<li>	
								<div class="form-check">
									<label class="form-check-label">
									<input class="form-check-input" type="radio" name="question2" value="anger">
									<img src=https://c8.alamy.com/comp/MABP97/donald-duck-illustration-cartoon-angry-MABP97.jpg>
								</label>
								</div>
							</li>	
						</ol>
						
						</div>
						
						<h3>3. You're cornered by your enemies. Think fast! Weapon of choice?</h3>
						<ol>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question3" value="surprise"> Cast-iron frying pan.
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question3" value="happiness"> I can control climate, and am therefore, a god.
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question3" value="neutral"> Not worth the effort, I’m gardening.
									</label>
								</div>	
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question3" value="anger"> Withering glare.
									</label>
								</div>	
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question3" value="sadness"> Talk with me long enough, and I’ll drag you down with me.
									</label>
								</div>
							</li>
						</ol>
						
						<h3>4. It’s 6AM, and the Sun has fired her first peal of orange across the horizon. The new day is on its way inexorably through the blinds, and into your crusty eyeballs—this is your cue to:</h3>
						<ol>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question4" value="happiness">Seize the day; I’m thinking of doing as many as six impossible things before breakfast!
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question4" value="surprise">Oh crap, I’ve got all that stuff I’ve got to do! (Charges like bull through Pfaltzgraff’s)
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question4" value="neutral">Gee, I’ve only just noticed how much this blanket feels like heaven… (Hits the snooze)
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question4" value="anger">Whoever or whatever is trying to wake me up is about meet their end via deadblow mallet.
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question4" value="sadness">I must invite you… to just leave me alone. (Draws curtains)
									</label>
								</div>
							</li>
						</ol>
						
						<h3>5. Which quote do you identify with the most?</h3>
						<ol>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question5" value="neutral">"Your identity is your most valuable possession. Protect it."!
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question5" value="surprise">“It’s true love!”
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question5" value="anger">“I never go back on my word!”
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question5" value="sadness">“Forever is a long time, and time has a way of changing things.”
									</label>
								</div>
							</li>
							<li>
								<div class="form-check">
									<label class="form-check-label">
										<input class="form-check-input" type="radio" name="question5" value="happiness">"Venture outside your comfort zone. The rewards are worth it."
									</label>
								</div>
							</li>
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