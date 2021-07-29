<?php

namespace App\Controller;

use App\Entity\User;
use App\Entity\Wish;
use App\Form\WishType;
use App\Repository\WishRepository;
use App\Services\Censurator;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/wish", "wish_")
 */
class WishController extends AbstractController
{
    /**
     * @Route("/list", "list")
     */
    public function list(WishRepository $wishRepository): Response
    {
        $wishes = $wishRepository->displayIdeasByAuthorName();

        return $this->render('wish/list.html.twig', ["wishes" => $wishes]);
    }

    /**
     * @Route("/details/{id}", "details")
     */
    public function details($id, WishRepository $wishRepository): Response
    {
        $wish = $wishRepository->find($id);

        return $this->render('wish/details.html.twig', ["wish" => $wish]);
    }

    /**
     * @Route("/create_wish", "create")
     */
    public function createWish(Request $request, EntityManagerInterface $entityManager, Censurator $censurator): Response
    {
        $wish = new Wish();
        /**
         * @var User $user
         */
        $user = $this->getUser();
        $wish->setAuthor($user->getUsername());
        $wish->setDateCreated(new \DateTime());
        $wishForm = $this->createForm(WishType::class, $wish);

        $wishForm->handleRequest($request);

        if($wishForm->isSubmitted()) {
            $purifiedTitle = $censurator->purify($wish->getTitle());
            $purifiedDescription = $censurator->purify($wish->getDescription());
            $wish->setTitle($purifiedTitle);
            $wish->setDescription($purifiedDescription);
            $entityManager->persist($wish);
            $entityManager->flush();
            $this->addFlash('success', 'Wish correctement sauvegardé dans la base de données ! ');
            return $this->redirectToRoute('app_wish_list');
        }

        return $this->render('wish/create.html.twig', ['wishForm' => $wishForm->createView()]);
    }

}
