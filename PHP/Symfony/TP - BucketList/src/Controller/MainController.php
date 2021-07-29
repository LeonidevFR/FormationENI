<?php


namespace App\Controller;

use http\Env\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Routing\Annotation\Route;

class MainController extends AbstractController
{

    /**
     * @Route("/", "main_home")
     */
    public function home()
    {
        return $this->render("home.html.twig");
    }

    /**
     * @Route("/about", "main_about")
     */
    public function about()
    {
        return $this->render("aboutus.html.twig");
    }

}